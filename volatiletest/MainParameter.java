package volatiletest;

import java.util.HashMap;
import java.util.Map;

public class MainParameter {
    public static int flag = 0;
    public static Map<String, String> getMap() {
        return map;
    }

    public static void setMap(Map<String, String> map) {
        MainParameter.map = map;
    }

    private static Map<String, String> map = new HashMap<>();
}
