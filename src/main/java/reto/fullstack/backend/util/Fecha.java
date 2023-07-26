package reto.fullstack.backend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Fecha {
    public static Date obtenerFecha() {
        Calendar calendar = Calendar.getInstance();
        Date fecha = new Date();

        fecha = calendar.getTime();

        TimeZone timeZone = TimeZone.getTimeZone("America/Lima");
        SimpleDateFormat formatterWithTimeZone = new SimpleDateFormat("dd-MM-yyyy");
        formatterWithTimeZone.setTimeZone(timeZone);
        String sDate = formatterWithTimeZone.format(fecha);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dateWithTimeZone = new Date();
        try {
            dateWithTimeZone = formatter.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateWithTimeZone;
    }
}
