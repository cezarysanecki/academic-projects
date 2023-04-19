package pl.csanecki.AITSI.util;

public class NameFormatter {
    public static String getNameWithFirstCapitalLetter(String name) {
        String returnName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        return returnName;
    }
}
