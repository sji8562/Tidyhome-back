package com.tenco.projectinit._core.utils;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static Time convertStringToTime(String timeString) {
        // DateTimeFormatter를 사용하여 문자열을 LocalTime으로 파싱
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(timeString, formatter);

        // LocalTime을 java.sql.Time으로 변환
        return Time.valueOf(localTime);
    }

    public static Date convertStringToDate(String dateString) {
        try {
            // SimpleDateFormat을 사용하여 문자열을 Date로 파싱
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return (Date) sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // 예외 발생 시 null 반환 또는 예외 처리 로직 추가
        }
    }
}
