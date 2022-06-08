package kr.codingtree.seonconfig.test;

import kr.codingtree.seonconfig.serializer.ValueSerializer;

public class SeonSerializer extends ValueSerializer<SeonField> {

    @Override
    public String serializer(SeonField value) {
        return value.getKey() + "::" + value.getValue();
    }

    @Override
    public SeonField deserializer(String value) {
        String[] valueSplit = value.split("::");
        return new SeonField(valueSplit[0], valueSplit[1]);
    }

}
