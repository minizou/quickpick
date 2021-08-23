package mini.decision_maker;

import android.app.Application;

public class StringsApp extends Application {
    private static String[] choices = new String[5];

    public static String getOption(int index) {
        if (index < 5 && index >= 0) {
            return choices[index];
        } else { return null; }
    }

    public static void setOption(int index, String s) {
        if (index < 5 && index >= 0) {
            choices[index] = s;
        }
    }
}
