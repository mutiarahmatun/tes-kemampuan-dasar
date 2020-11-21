package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.util;

import java.util.Locale;

public class LocaleCheck {

    public static boolean isLocaleIndonesia() {
        return Locale.getDefault().getDisplayLanguage().equals("Indonesia");
    }

}
