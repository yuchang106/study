import java.util.HashMap;
import java.util.Map;

public class HelloTest {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new HashMap<>();
        map.put("name", "yzy");
        map.clear();
        System.out.println(map.get("name"));

//        while(true) {
//            Thread.sleep(1000);
//            ResourceBundle.clearCache();
//            ResourceBundle bundle = ResourceBundle.getBundle("seckit");
//            System.out.println("["+bundle.getString("seckit.node.id")+"]");
//        }
    }
}
