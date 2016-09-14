package emil.magerramov.util;

/**
 * Created by lemhell on 13.09.16.
 */
public class Util {
    public static String tab(int level) {
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < level; i++) {
            tab.append("    ");
        }
        return tab.toString();
    }
}
