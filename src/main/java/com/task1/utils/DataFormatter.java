package com.task1.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DataFormatter {
    public static String getDataTime(String zone){
        ZoneId timeZone = ZoneId.of(zone);
        ZonedDateTime zoneTime = ZonedDateTime.now(timeZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        return zoneTime.format(formatter);
    }
}
