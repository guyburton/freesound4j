package org.freesound.apiv1.filter;

public class StringFilter extends Filter {

    StringFilter(FilterField field) {
        super(field);
    }

    public StringFilter equalTo(String value) {
        setStringValue(quote(value));
        return this;
    }

    private String quote(String value) {
        return value.contains(" ") ? "\"" +value + "\"" : value;
    }
}
