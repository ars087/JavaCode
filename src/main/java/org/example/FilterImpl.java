package org.example;

public class FilterImpl implements Filter {

    @Override
    public Object apply(Object object) {

        if (object instanceof String) {
            return ((String) object).toUpperCase();
        } else if (object instanceof Number && (Integer) object % 2 == 0) {
            return object;
        } else if (object instanceof Character) {
            return Character.toUpperCase((Character) object);
        } else if (object instanceof Boolean && !((Boolean) object)) {
            return true;
        }

        return null;
    }

}
