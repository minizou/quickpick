package mini.decision_maker;

import android.app.Application;

public class StringsApp extends Application {
    private static String[] options = new String[5];

    public static String getOption(int index) {
        if (index < 5 && index >= 0) {
            return options[index];
        } else { return null; }
    }

    public static void setOption(int index, String s) {
        if (index < 5 && index >= 0) {
            options[index] = s;
        }
    }

    public static void printOptions() {
        String temp = "";
        for (String s : options) {
            temp += s + " ";
        }
        System.out.println(temp);
    }
}
