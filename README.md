# SeonConfig

## Example
### YamlConfig Example
``` Java
public class TestClass {

    public static void main(String[] args) {
        YamlConfig config = new YamlConfig(new File("config.yml"));
        config.load();
        config.save();
    }
    
}
```

### Console
``` text
1
```