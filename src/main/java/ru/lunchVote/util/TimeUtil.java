package ru.lunchVote.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

// Sweets
public class TimeUtil {

    private static final LocalTime LOCAL_TIME = LocalTime.of(11, 00, 00);

    public static boolean checkTime(LocalDateTime localDateTime){
        if(localDateTime.toLocalTime().compareTo(LOCAL_TIME) < 0){
            return true;
        }
        return false;
    }
}
