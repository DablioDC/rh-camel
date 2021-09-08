package br.com.unicoob.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final FeriadoRules FERIADO_RULES = new FeriadoRules();

    public static Date proximaDataUtil(Date data) {
        boolean dataValida = false;
        while (!dataValida) {
            data = adicionarDia(data, 1);
            if (diaIsUtil(data, 0)) {
                dataValida = true;
            }
        }
        return data;
    }


    public static boolean diaIsUtil(Date data, int quantidade) {
        data = adicionarDia(data, quantidade);
        return FERIADO_RULES.isDiaUtil(data);
    }


    public static Date adicionarDia(Date date, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, amount);
        return calendar.getTime();
    }

    public static Date lowerLimit(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTime();
        }
    }
}
