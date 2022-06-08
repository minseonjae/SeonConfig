package kr.codingtree.seonconfig.test;

import kr.codingtree.seonconfig.JsonConfig;
import kr.codingtree.seonconfig.SeonConfig;
import kr.codingtree.seonconfig.serializer.Serializers;

import java.io.File;

public class SeonConfigTest {

    public static void main(String[] args) {
        Serializers.register(SeonSerializer.class);

        File file = new File("seonconfig.json");
        SeonConfig config = new SeonConfig(SeonDataBase.class, JsonConfig.class);
        config.load(file);

        SeonField field1 = new SeonField("a", "b");
        SeonField field2 = new SeonField("b", "c");
        SeonField field3 = new SeonField("c", "d");
        SeonField field4 = new SeonField("d", "e");
        SeonDataBase.getMap1().put("a", field1);
        SeonDataBase.getMap2().put("b", field2);
        SeonDataBase.getList1().add(field3);
        SeonDataBase.getList2().add(field4);
        config.save(file);


        System.out.println("----------");
        System.out.println("map1 : " + SeonDataBase.getMap1());
        System.out.println("map2 : " + SeonDataBase.getMap2());
        System.out.println("list1 : " + SeonDataBase.getList1());
        System.out.println("list2 : " + SeonDataBase.getList2());
    }
}
