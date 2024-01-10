package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationJPARepository extends JpaRepository<Reservation, Integer> {
    //    @Query(value = "select count(o) from Order o left join o.items i where DATE(i.paymentTime) = CURDATE()")
    //    int findTotalOrders();

    @Query("SELECT i.id AS reservationId, i.reservationDate AS reservationDate, " +
                "i.reservationTime AS reservationTime,"
            + "fc.name AS firstCategory "
            + "FROM AddressInfo ai "
            + "JOIN Reservation r ON ai.id = r.addressInfo.id "
            + "JOIN Info i ON r.info.id = i.id "
            + "JOIN ReservationSuc rs ON r.id = rs.reservation.id "
            + "JOIN Option o ON o.id = i.option.id "
            + "JOIN SecondCategory sc ON sc.id = o.secondCategory.id "
            + "JOIN FirstCategory fc ON fc.id = sc.firstCategory.id "
            + "WHERE ai.user.id = :userId")
    Optional<ReservationDetailResponseDTO.ReservationList> findReservationByUserId(@Param("userId") Integer userId); // 예약 목록

    @Query("SELECT ai.address AS address, ai.addressDetail AS addressDetail, "
            + "i.reservationDate AS reservationDate, i.reservationTime AS reservationTime, i.pet AS pet, "
            + "s.price AS price, "
            + "fc.name AS firstCategory, "
            + "sc.name AS secondCategory, "
            + "o.name AS option "
            + "FROM AddressInfo ai "
            + "JOIN Reservation r ON ai.id = r.addressInfo.id "
            + "JOIN Info i ON r.info.id = i.id "
            + "JOIN ReservationSuc rs ON r.id = rs.reservation.id "
            + "JOIN Sale s ON rs.sale.id = s.id "
            + "JOIN Option o ON o.id = i.option.id "
            + "JOIN SecondCategory sc ON sc.id = o.secondCategory.id "
            + "JOIN FirstCategory fc ON fc.id = sc.firstCategory.id "
            + "WHERE r.id = :resevationId")
    Optional<ReservationDetailResponseDTO.ReservationDetail> findReservationDetailById(@Param("reservationId") Integer reservationId); // 예약 내역 상세


}

