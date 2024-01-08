package com.tenco.projectinit.dto.responsedto;

import java.sql.Date;
import java.sql.Time;

public class ReservationDetailResponseDTO {

    // addressInfo_tb
    private String address;
    private String addressDetail;

    // info_tb
    private Date reservationDate;
    private Time reservationTime;
    private Boolean pet;

    // sale_tb
    private Integer userId;
    private Integer price;
    private String tid;

    // card_tb
    private String provider;

}
