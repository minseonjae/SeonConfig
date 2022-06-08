import kr.codingtree.seonconfig.JsonConfig;
import kr.codingtree.seonconfig.YamlConfig;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class TestConfig {

    public static void main(String[] args) {
//        YamlConfig config = new YamlConfig();
        JsonConfig config = new JsonConfig();
        config.addDefault("a", 1);
        config.addDefault("b", Arrays.asList("a", "b", "민"));
        config.addDefault("c.a", "a");
        config.addDefault("c.c", "b");
        config.addDefault("e.a", "a");
        config.addDefault("e.b", "b");
        config.addDefault("민", "a");
        config.addDefault("d.d.d.d.d", "d");
        config.addDefault("c.b", Arrays.asList(1, 2, 3));
//        config.load(new File("test.yml"));
        config.load(new File("test.json"));
    }
}
