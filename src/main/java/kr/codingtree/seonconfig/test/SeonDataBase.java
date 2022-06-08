package kr.codingtree.seonconfig.test;

import kr.codingtree.seonconfig.annotation.ConfigExclude;
import kr.codingtree.seonconfig.annotation.ConfigName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SeonDataBase {

    @Getter
    @ConfigName("a.a")
    private static HashMap<String, SeonField> map1 = new LinkedHashMap<>();

    @Getter
    @ConfigExclude
    private static HashMap<String, SeonField> map2 = new LinkedHashMap<>();

    @Getter
    @ConfigName("a.b")
    private static ArrayList<SeonField> list1 = new ArrayList<>();

    @Getter
    @ConfigExclude
    private static ArrayList<SeonField> list2 = new ArrayList<>();

    @Getter
    @Setter
    private static String name = "asdf";
}
