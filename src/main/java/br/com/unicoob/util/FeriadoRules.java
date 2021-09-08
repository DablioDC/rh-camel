//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package br.com.unicoob.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FeriadoRules {
    private static final Set<FeriadoRules.FeriadoEstatico> FERIADO_LIST = new HashSet();

    public FeriadoRules() {
    }

    public boolean isDiaUtil(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int dayOfWeek = calendar.get(7);
        switch(dayOfWeek) {
        case 1:
        case 7:
            return false;
        default:
            return !this.isFeriadoNacional(data);
        }
    }

    public boolean isFeriadoNacional(Date data) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        Iterator pascoa = FERIADO_LIST.iterator();

        FeriadoRules.FeriadoEstatico feriadoEstatico;
        do {
            if(!pascoa.hasNext()) {
                Calendar pascoa1 = this.getPascoa(calendar.get(1));
                if(this.isSextaFeiraSanta(calendar, pascoa1)) {
                    return true;
                }

                if(this.isCorpus(calendar, pascoa1)) {
                    return true;
                }

                return this.isCarnaval(calendar, pascoa1);
            }

            feriadoEstatico = (FeriadoRules.FeriadoEstatico)pascoa.next();
        } while(feriadoEstatico.getMes() != calendar.get(2) || feriadoEstatico.getDia() != calendar.get(5));

        return true;
    }

    private boolean isCorpus(Calendar calendar, Calendar pascoa) {
        Calendar corpusChristi = (Calendar)pascoa.clone();
        corpusChristi.add(6, 60);
        return corpusChristi.get(2) == calendar.get(2) && corpusChristi.get(5) == calendar.get(5);
    }

    private boolean isSextaFeiraSanta(Calendar calendar, Calendar pascoa) {
        Calendar sextaFeiraSanta = (Calendar)pascoa.clone();
        sextaFeiraSanta.add(6, -2);
        return sextaFeiraSanta.get(2) == calendar.get(2) && sextaFeiraSanta.get(5) == calendar.get(5);
    }

    public boolean isCarnaval(Calendar calendar, Calendar pascoa) {
        Calendar carnaval = (Calendar)pascoa.clone();
        carnaval.add(6, -47);
        Calendar segundaCarnaval = (Calendar)pascoa.clone();
        segundaCarnaval.add(6, -48);
        return carnaval.get(2) == calendar.get(2) && carnaval.get(5) == calendar.get(5) || segundaCarnaval.get(2) == calendar.get(2) && segundaCarnaval.get(5) == calendar.get(5);
    }

    protected Calendar getPascoa(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int p = (h + l - 7 * m + 114) % 31;
        int month = (h + l - 7 * m + 114) / 31;
        int day = p + 1;
        return new GregorianCalendar(year, month - 1, day);
    }

    static {
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(0, 1));
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(3, 21));
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(4, 1));
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(8, 7));
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(9, 12));
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(10, 2));
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(10, 15));
        FERIADO_LIST.add(new FeriadoRules.FeriadoEstatico(11, 25));
    }

    private static class FeriadoEstatico {
        private int mes;
        private int dia;

        public FeriadoEstatico(int mes, int dia) {
            this.mes = mes;
            this.dia = dia;
        }

        public int getDia() {
            return this.dia;
        }

        public void setDia(int dia) {
            this.dia = dia;
        }

        public int getMes() {
            return this.mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public boolean equals(Object obj) {
            if(!(obj instanceof FeriadoRules.FeriadoEstatico)) {
                return false;
            } else {
                FeriadoRules.FeriadoEstatico other = (FeriadoRules.FeriadoEstatico)obj;
                return this.mes == other.mes && this.dia == other.dia;
            }
        }

        public int hashCode() {
            return Integer.toString(this.mes).hashCode() + Integer.toString(this.dia).hashCode();
        }
    }
}
