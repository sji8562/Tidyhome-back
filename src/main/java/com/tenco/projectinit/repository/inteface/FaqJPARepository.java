package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.mng.FaqResponseDTO;
import com.tenco.projectinit.dto.responsedto.FaqPartResponseDTO;
import com.tenco.projectinit.repository.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaqJPARepository extends JpaRepository<Faq, Integer> {
    @Query(value = "select fp.id as id,f.name as name,fp.title as title ,fp.code as code from Faq f left join FaqPart fp on f.id = fp.faq.id")
    List<FaqResponseDTO.faqListDTO> findAllWithFaqPart();

    @Query(value = "select f.id as faqId,f.name as name,fp.id as partId,fp.title as title,fp.content as content,fp.code as code from Faq f left join FaqPart fp where f.service.id = :id and fp.faq.id = 1")
    List<FaqPartResponseDTO.FaqJoinPartDTO> findAllAndServicesId(Integer id);

    @Query(value = "select f.id as faqId,f.name as name,fp.id as partId,fp.title as title,fp.content as content,fp.code as code from Faq f left join FaqPart fp where f.service.id = :id and fp.faq.id = :partId")
    List<FaqPartResponseDTO.FaqJoinPartDTO> findAllAndServicesIdAndPartId(Integer id,Integer partId);
}
