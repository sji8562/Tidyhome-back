package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ReservationJPARepository extends JpaRepository<Reservation, Integer> {
    //    @Query(value = "select count(o) from Order o left join o.items i where DATE(i.paymentTime) = CURDATE()")
    //    int findTotalOrders();

    @Query("SELECT ai.address AS address, ai.addressDetail AS addressDetail, "
            + "i.reservationDate AS reservationDate, i.reservationTime AS reservationTime, i.pet as pet, "
            + "s.price AS price, "
            + "fc.name AS FirstCategory, "
            + "sc.name AS SecondCategory, "
            + "o.name AS Option "
            + "FROM AddressInfo ai "
            + "JOIN Reservation r ON ai.id = r.addressInfo.id "
            + "JOIN Info i ON r.info.id = i.id "
            + "JOIN ReservationSuc rs ON r.id = rs.reservation.id "
            + "JOIN Sale s ON rs.sale.id = s.id "
            + "JOIN Option o ON o.id = i.option.id "
            + "JOIN SecondCategory sc ON sc.id = o.secondCategory.id "
            + "JOIN FirstCategory fc ON fc.id = sc.firstCategory.id "
            + "WHERE ai.user.id = :userId")
    List<Map<String, Object>> findUserAddressInfo(@Param("userId") Integer userId);
}

