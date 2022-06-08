import kr.codingtree.seonconfig.serializer.Serializers;
import kr.codingtree.seonconfig.serializer.ValueSerializer;

public class SerializerTest {
    public static void main(String[] args) {
        ValueSerializer<String> serializer1 = new ValueSerializer<String>() {
            @Override
            public String serializer(String value) {
                return "zxcv";
            }

            @Override
            public String deserializer(String value) {
                return "qwer";
            }
        };
        ValueSerializer<Integer> serializer2 = new ValueSerializer<Integer>() {
            @Override
            public String serializer(Integer value) {
                return "2";
            }

            @Override
            public Integer deserializer(String value) {
                return 1;
            }
        };

        Serializers.register(serializer1);
        Serializers.register(serializer2);

        String name = "asdf";
        int iname = 5;

        System.out.println(Serializers.isRegistered(name));
        System.out.println(Serializers.isRegistered(iname));
        System.out.println(Serializers.isRegistered(Integer.class));
    }
}
