package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.mng.FaqResponseDTO;
import com.tenco.projectinit.repository.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaqJPARepository extends JpaRepository<Faq, Integer> {
    @Query(value = "select fp.id as id,f.name as name,fp.title as title,fp.code as code from Faq f left join FaqPart fp on f.id = fp.faq.id")
    List<FaqResponseDTO.faqListDTO> findAllWithFaqPart();
}
