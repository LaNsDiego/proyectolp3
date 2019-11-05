package com.teamnab.demo.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Calendario {
    public static SimpleDateFormat FechaFormatoDb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Calendar calendario = Calendar.getInstance();

    public static String hoy(){
        calendario.setTime(new Date());
        return FechaFormatoDb.format(calendario.getTime());
    }

    public static String aumentarDias(Date fecha , int dias){
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE,3);
        return FechaFormatoDb.format(calendario.getTime());
    }
}
