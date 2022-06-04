package kr.codingtree.seonconfig;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.util.HashMap;

public class YamlConfig extends FileConfig {

    @Override
    public String saveToString() {
        return getYaml().dump(organizedMap(addDefaultValues(values)));
    }

    @Override
    public HashMap<String, Object> stringToMap(String mapString) {
        return getYaml().load(mapString);
    }

    private Yaml getYaml() {
        Representer representer = new Representer();
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        return new Yaml(new Constructor(), representer, options);
    }

}
