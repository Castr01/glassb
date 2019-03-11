package cGlassblower.data;

public class Data {

    public static long startTime;

    public  static  final String formatTime(final long ms) {
        long s = ms / 1000, m = s / 60, h = m / 60, d = h / 24;
        s %= 60;
        m %= 60;
        h %= 24;

        return d > 0 ? String.format("%02d:%02d:%02d:%02d", d, h, m, s)
                : h > 0 ? String.format("%02d:%02d:%02d", h, m, s) : String.format("%02d:%02d", m, s);
    }

    public static long lastAnimation = 0;

    public static int moltenGlassCount = 1;

    public static int fishbowl = 4;
    public static int lens = 6;
    public static int lightOrb = 7;

    public static int start_level = 0;
    public static int start_xp = 0;


}
