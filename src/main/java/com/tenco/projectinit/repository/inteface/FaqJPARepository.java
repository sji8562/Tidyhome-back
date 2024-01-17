package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.mng.FaqResponseDTO;
import com.tenco.projectinit.dto.responsedto.FaqPartResponseDTO;
import com.tenco.projectinit.repository.entity.Faq;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaqJPARepository extends JpaRepository<Faq, Integer> {
    @Query(value = "select fp.id as id,f.name as name,fp.title as title ,fp.code as code from Faq f left join FaqPart fp on f.id = fp.faq.id")
    List<FaqResponseDTO.faqListDTO> findAllWithFaqPart();

    @Query(value = "select new com.tenco.projectinit.dto.responsedto.FaqPartResponseDTO$FaqJoinPartDTO(ft.id as faqId, ft.name as name,fpt.id as partId,fpt.title as title,fpt.content as content,fpt.code as code) " +
            "from Faq ft left join FaqPart fpt on ft.id = fpt.faq.id" +
            " where ft.service.id = :id and ft.id = :partId")
    List<FaqPartResponseDTO.FaqJoinPartDTO> findAllAndServicesIdAndPartId(@Param("id") Integer id, @Param("partId") Integer partId);
}