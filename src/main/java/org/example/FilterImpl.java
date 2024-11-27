package org.example;

public class FilterImpl implements Filter {

    @Override
    public Object apply(Object object) {

        if (object instanceof String) {
            return ((String) object).toUpperCase();
        }
        return null;
    }

}
