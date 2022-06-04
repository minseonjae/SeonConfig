package kr.codingtree.seonconfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class JsonConfig extends FileConfig {

    @Override
    public String saveToString() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create()
                .toJson(organizedMap(addDefaultValues(values)));
    }

    @Override
    public HashMap<String, Object> stringToMap(String mapString) {
        return new Gson().fromJson(mapString, LinkedHashMap.class);
    }

}
