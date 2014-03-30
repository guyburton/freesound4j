package org.freesound.apiv1.filter;

public abstract class Filter {

    protected static final String ANY = "*";
    private final FilterField currentFilterField;
    private String value;

    Filter(FilterField currentFilterField) {
        this.currentFilterField = currentFilterField;
    }

    protected void setStringValue(String stringValue) {
        this.value = stringValue;
    }

    protected void setRangeValue(String value1, String value2) {
        this.value = "[" + value1 + " TO " + value2 + "]";
    }

    private String createFilterString(String value) {
        return currentFilterField.getDescription() + ":" + value;
    }

    @Override
    public String toString() {
        return createFilterString(value);
    }

}
