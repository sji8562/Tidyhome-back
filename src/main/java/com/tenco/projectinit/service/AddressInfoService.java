package com.tenco.projectinit.service;

import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.inteface.AddressInfoJPARepository;
import com.tenco.projectinit.repository.inteface.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressInfoService {

    @Autowired
    private AddressInfoJPARepository addressInfoJPARepository;
    @Autowired
    private UserJPARepository userJPARepository;

    public AddressInfo addAddressInfo(AddressInfo addressInfo, int userId) {
        // 이미 존재하는 유저 가져오기
        Optional<User> userOptional = userJPARepository.findById(userId);

        // 주소 정보와 유저 정보 연결
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            addressInfo.setUser(user);
            // 대표 주소 설정
            setMainAddress(user.getId(),addressInfo);
        } else {
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }
        // 주소 정보 저장
        return addressInfoJPARepository.save(addressInfo);
    }

    // 대표 주소 설정 메서드
    public void setMainAddress(int userId, AddressInfo addressInfo) {
        List<AddressInfo> addressList = addressInfoJPARepository.findByUserId(userId);

        // 대표 주소 초기화
        if (!addressList.isEmpty()) {
            for (AddressInfo address : addressList) {
                address.setChoice(false);
            }
        }
        addressInfo.setChoice(true);
        // 대표 주소 정보 저장
        addressInfoJPARepository.saveAll(addressList);
    }
}