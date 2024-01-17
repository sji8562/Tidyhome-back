package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;

import com.tenco.projectinit.repository.entity.Info;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationJPARepository extends JpaRepository<Reservation, Integer> {
    //    @Query(value = "select count(o) from Order o left join o.items i where DATE(i.paymentTime) = CURDATE()")
    //    int findTotalOrders();

//    @Query("SELECT new com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO$ReservationList(i.id AS reservationId, i.reservationDate, i.reservationTime, fc.name) "
//            + "FROM AddressInfo ai "
//            + "JOIN Reservation r ON ai.id = r.addressInfo.id "
//            + "JOIN Info i ON r.info.id = i.id "
//            + "JOIN ReservationSuc rs ON r.id = rs.reservation.id "
//            + "JOIN Option o ON o.id = i.option.id "
//            + "JOIN SecondCategory sc ON sc.id = o.secondCategory.id "
//            + "JOIN FirstCategory fc ON fc.id = sc.firstCategory.id "
//            + "JOIN Sale s ON s.id = rs.sale.id "
//            + "WHERE ai.user.id = :userId "
//            + "AND s.status = 1 ")
//    List<ReservationDetailResponseDTO.ReservationList> findReservationByUserId(@Param("userId") Integer userId); // 예약 목록

//    @Query("SELECT new com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO$ReservationCompleteList(i.id AS reservationId, i.reservationDate, i.reservationTime, fc.name,s.status) "
//            + "FROM AddressInfo ai "
//            + "JOIN Reservation r ON ai.id = r.addressInfo.id "
//            + "JOIN Info i ON r.info.id = i.id "
//            + "JOIN ReservationSuc rs ON r.id = rs.reservation.id "
//            + "JOIN Option o ON o.id = i.option.id "
//            + "JOIN SecondCategory sc ON sc.id = o.secondCategory.id "
//            + "JOIN FirstCategory fc ON fc.id = sc.firstCategory.id "
//            + "JOIN Sale s ON s.id = rs.sale.id "
//            + "WHERE ai.user.id = :userId "
//            + "AND s.status IN (2, 3, 4) ")
//    List<ReservationDetailResponseDTO.ReservationCompleteList> findCompletedReservationByUserId(@Param("userId") Integer userId); // 예약 완료 목록

//    @Query("SELECT new com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO$ReservationDetail(ai.address AS address, ai.addressDetail AS addressDetail, "
//            + "i.reservationDate AS reservationDate, i.reservationTime AS reservationTime, i.pet AS pet, "
//            + "s.price AS price, "
//            + "fc.name AS firstCategory, "
//            + "sc.name AS secondCategory, "
//            + "o.name AS option)"
//            + "r.id AS reservationId)"
//            + "FROM AddressInfo ai "
//            + "JOIN Reservation r ON ai.id = r.addressInfo.id "
//            + "JOIN Info i ON r.info.id = i.id "
//            + "JOIN Sale s ON rs.sale.id = s.id "
//            + "JOIN Option o ON o.id = i.option.id "
//            + "JOIN SecondCategory sc ON sc.id = o.secondCategory.id "
//            + "JOIN FirstCategory fc ON fc.id = sc.firstCategory.id "
//            + "WHERE r.id = :reservationId")
//    ReservationDetailResponseDTO.ReservationDetail findReservationDetailById(@Param("reservationId") Integer reservationId); // 예약 내역 상세



    Reservation findById(int id);

    Optional<Reservation> findByInfo(Info info);
    List<Reservation> findByAddressInfo_User_IdAndStatusIn(Integer userId, List<Integer> statusList);


}

