package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.CustomRestfullException;
import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit._core.utils.Define;
import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.inteface.PartnerJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PartnerService {

    @Autowired
    private PartnerJPARepository partnerJPARepository;

    public List<Partner> findByLevel() {
        List<Partner> partnerList = partnerJPARepository.findAll();
        if (partnerList.isEmpty() || partnerList == null) {
            throw new Exception500("파트너가 없습니다.");
        }
        return partnerList;
    }

    public Page<Partner> findByPageNation(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<Partner> partnerPG = partnerJPARepository.findAll(pageable);
        if (partnerPG.isEmpty() || partnerPG == null) {
            throw new Exception500("파트너가 없습니다.");
        }
        List<Partner> modifiedList = parseCate(partnerPG);

        return partnerPG;
    }

    public Page<Partner> findByPageNation(Integer page, String keyword) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<Partner> partnerPG = partnerJPARepository.findByUsernameContaining(keyword, pageable);
        if (partnerPG.isEmpty() || partnerPG == null) {
            throw new Exception500("파트너가 없습니다.");
        }
        List<Partner> modifiedList = parseCate(partnerPG);
        return partnerPG;
    }

    /**
     * 파트너 리스트 페이지 카테고리 아이디 파싱
     *
     * @param partnerPG
     * @return
     */
    public List<Partner> parseCate(Page<Partner> partnerPG) {
        return partnerPG.getContent().stream()
                .peek(partner -> {
                    if (partner.getCategoryId() != null) {
                        List<String> categories = Arrays.asList(partner.getCategoryId().split(","));
                        System.out.println(categories.stream().toList());
                        String category = "";
                        for (int i = 0; i < categories.size(); i++) {
                            if (categories.get(i).equals("1")) {
                                if (i != 0) {
                                    category += ",가사 도우미";
                                } else {
                                    category += " 가사 도우미";
                                }
                            } else if (categories.get(i).equals("2")) {
                                if (i != 0) {
                                    category += ",사무실 청소";
                                } else {
                                    category += " 사무실 청소";
                                }

                            } else if (categories.get(i).equals("3")) {
                                if (i != 0) {
                                    category += ",가전 / 침대 청소";
                                } else {
                                    category += " 가전 / 침대 청소";
                                }

                            } else if (categories.get(i).equals("4")) {
                                if (i != 0) {
                                    category += ",이사 청소";
                                } else {
                                    category += " 이사 청소";
                                }
                            }
                        }
                        category = category.trim();
                        partner.setCategoryId(category);
                    }
                })
                .collect(Collectors.toList());
    }

    // 파트너 카테고리 아이디 파싱
    public Optional<Partner> parseCateparse(Optional<Partner> partner) {
        if (partner.get().getCategoryId() != null) {
            List<String> categories = Arrays.asList(partner.get().getCategoryId().split(","));
            System.out.println(categories.stream().toList());
            String category = "";
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).equals("1")) {
                    if (i != 0) {
                        category += ",가사 도우미";
                    } else {
                        category += " 가사 도우미";
                    }
                } else if (categories.get(i).equals("2")) {
                    if (i != 0) {
                        category += ",사무실 청소";
                    } else {
                        category += " 사무실 청소";
                    }

                } else if (categories.get(i).equals("3")) {
                    if (i != 0) {
                        category += ",가전 / 침대 청소";
                    } else {
                        category += " 가전 / 침대 청소";
                    }

                } else if (categories.get(i).equals("4")) {
                    if (i != 0) {
                        category += ",이사 청소";
                    } else {
                        category += " 이사 청소";
                    }
                }
            }
            category = category.trim();
            partner.get().setCategoryId(category);
        }
        return partner;

    }

    @Transactional
    public void deleteById(Integer id) {
        partnerJPARepository.deleteById(id);
    }

    public Optional<Partner> findById(Integer id) {
        Optional<Partner> partner = partnerJPARepository.findById(id);
        return parseCateparse(partner);
    }

    public void updateById(PartnerRequestDTO.UpdateDTO dto) {


        String parse = dto.getCategory();
        String temp = "";
        for (int i = 0; i < parse.length(); i++) {
            if (i == 0) {
                temp += parse.split("")[i];
            } else {
                temp += "," + parse.split("")[i];
            }

//            partnerJPARepository.updateByPartnerId(dto.getId(),dto.getUsername(),dto.getTel(),temp);
//                return 0;


        }
    }
}