package com.unitedinternet.jam.konten.model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by agrunow on 28.11.16.
 */
public class ZeitBean {

    public ZeitBean() {
    }

    public String getZeit() {
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Europe/Paris"));
        return time.format(DateTimeFormatter.ISO_DATE);
    }
}
