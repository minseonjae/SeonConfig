package kr.codingtree.seonconfig.section;

public interface CheckSection extends GetSection {

    default boolean isString(String key) {
        Object value = get(key);
        return value != null && value instanceof String;
    }

    default boolean isInt(String key) {
        Object value = get(key);
        if (value == null) return false;
        try {
            Integer.parseInt(value.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    default boolean isLong(String key) {
        Object value = get(key);
        if (value == null) return false;
        try {
            Long.parseLong(value.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    default boolean isShort(String key) {
        Object value = get(key);
        if (value == null) return false;
        try {
            Short.parseShort(value.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    default boolean isFloat(String key) {
        Object value = get(key);
        if (value == null) return false;
        try {
            Float.parseFloat(value.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    default boolean isDouble(String key) {
        Object value = get(key);
        if (value == null) return false;
        try {
            Double.parseDouble(value.toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
