# Platform-Config

Bukkit & BungeeCord Config Library

### __Required List__ _(already included)_
__- Spigot__\
__- BungeeCord__\
__- lombok__

## Example
### TestPlugin.java
``` Java
public class TestPlugin extends JavaPlugin {
    private Config config = new Config(getDataFoler(), "config.yml");
    @Override
    public void onEnable() {
        config.addDefault("test1", "111");
        config.addDefault("test2", 222);
        config.addDefault("test3", 1.0);
        config.addDefault("test4", 2.0);
        config.save();
        System.out.println(config.getString("test1"));
        System.out.println(config.getInt("test2"));
        System.out.println(config.getDouble("test3"));
        System.out.println(config.getFloat("test4"));
        config.set("test1", "333");
        System.out.println(config.getString("test1"));
    }
}
```

### Console
``` text
111
222
1.0
2.0
333
```