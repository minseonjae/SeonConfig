import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenericClassTest {

    private HashMap<String, Integer> map = new HashMap<String, Integer>();
    private ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            GenericClassTest test = new GenericClassTest();
            for (Field field : test.getClass().getDeclaredFields()) {

                Type type = field.getGenericType();

                if (type instanceof ParameterizedType) {
                    for (Type ftype : ((ParameterizedType) type).getActualTypeArguments()) {
                        System.out.println(ftype);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
