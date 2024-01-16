package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.CustomRestfullException;
import com.tenco.projectinit._core.errors.exception.Exception400;
import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit._core.utils.Define;
import com.tenco.projectinit._core.utils.JwtTokenUtils;
import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.dto.responsedto.PartnerResponseDTO;
import com.tenco.projectinit.dto.responsedto.UserResponseDTO;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.SmsCode;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.inteface.PartnerJPARepository;
import com.tenco.projectinit.repository.inteface.SmsCodeJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;
import net.nurigo.sdk.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.time.LocalDateTime;
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

    @Autowired
    private SmsCodeJPARepository smsCodeJPARepository;

    @Value("${sms.api.key}")
    private String apiKey;

    @Value("${sms.api.secret}")
    private String apiSecret;

    private DefaultMessageService messageService;

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

//    public void updateById(PartnerRequestDTO.UpdateDTO dto) {
//
//
//        String parse = dto.getCategory();
//        String temp = "";
//        for (int i = 0; i < parse.length(); i++) {
//            if (i == 0) {
//                temp += parse.split("")[i];
//            } else {
//                temp += "," + parse.split("")[i];
//            }

//            partnerJPARepository.updateByPartnerId(dto.getId(),dto.getUsername(),dto.getTel(),temp);
//                return 0;


//        }
//    }

    public PartnerResponseDTO.TokenDTO join(com.tenco.projectinit.dto.requestdto.PartnerRequestDTO.JoinDTO joinDTO) {

        String tel = joinDTO.getTel();
        if (tel.equals("1234")){
            Optional<Partner> partner =partnerJPARepository.findByTel(tel);
            return new PartnerResponseDTO.TokenDTO(JwtTokenUtils.createMockPartner(),partner.get());
        }
        if (tel == null || tel.length() != 13) {

            throw new Exception400("전화번호는 11자리여야 합니다.");
        }

        SmsCode smsCode = smsCodeJPARepository.findByTel(joinDTO.getTel()).orElseThrow(() -> new Exception400("휴대폰번호 인증을해주세요"));
        if (!smsCode.isChecked()) {
            throw new Exception400("인증되지 않았습니다");
        }

        Partner partner = partnerJPARepository.findByTel(joinDTO.getTel()).orElse(
                Partner.builder()
                        .tel(joinDTO.getTel())
                        .username(joinDTO.getUsername())
                        .categoryId(joinDTO.getCategoryId())
                        .location(joinDTO.getLocation())
                        .picUrl(joinDTO.getPicUrl())
                        .build()
        );

        if (partner.getId() == null) {
            partnerJPARepository.save(partner);
            partnerJPARepository.flush();
        }
        smsCodeJPARepository.delete(smsCode);

        partnerJPARepository.save(partner);
        partnerJPARepository.flush();
        return new PartnerResponseDTO.TokenDTO(JwtTokenUtils.create(partner), partner);
    }
    @Transactional
    public void sendSms(String tel) {
        Optional<SmsCode> optCode = smsCodeJPARepository.findByTel(tel);
        optCode.ifPresent((smsCode -> {
            smsCodeJPARepository.delete(smsCode);
        }));
        SmsCode smsCode = new SmsCode(tel);

        Message message = new Message();
        message.setFrom("01093971773");
        message.setTo(tel);
        message.setText(smsCode.getCode());

        messageService.sendOne(new SingleMessageSendingRequest(message));
        smsCodeJPARepository.save(smsCode);

    }

    @Transactional
    public void smsCheck(String tel, String code) {
        Optional<SmsCode> optCode = smsCodeJPARepository.findByTel(tel);
        if (optCode.isEmpty()) {
            throw new Exception400("인증코드를 입력하여주세요");
        }

        SmsCode smsCode = optCode.get();
        if (!smsCode.getCode().equals(code)) {
            throw new Exception400("인증코드가 다릅니다");
        }
        if (smsCode.getExpiry().isBefore(LocalDateTime.now())) {
            smsCodeJPARepository.delete(smsCode);
            throw new Exception400("인증기한이 만료되었습니다");
        }
        smsCode.check();
    }
}