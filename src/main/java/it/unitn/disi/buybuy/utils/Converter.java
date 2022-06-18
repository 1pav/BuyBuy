package it.unitn.disi.buybuy.utils;

public class Converter {

    public static Integer parseInt(String parameter) {
        Integer res = null;

        try {
            res = Integer.parseInt(parameter);
        } catch (NumberFormatException ex) {
            res = null;
        }

        return res;
    }

    public static Float parseFloat(String parameter) {
        Float res = null;

        try {
            res = Float.parseFloat(parameter);
        } catch (NumberFormatException ex) {
            res = null;
        }

        return res;
    }

}
