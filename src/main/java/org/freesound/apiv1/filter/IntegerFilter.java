package org.freesound.apiv1.filter;

import java.math.BigDecimal;

public class IntegerFilter extends Filter {

    IntegerFilter(FilterField currentFilterField) {
        super(currentFilterField);
    }

    public IntegerFilter isBetween(int value1, int value2) {
        setRangeValue(getIntValue(value1), getIntValue(value2));
        return this;
    }

    public IntegerFilter lessThan(int value) {
        setRangeValue(FilterBuilder.ANY, getIntValue(value));
        return this;
    }

    public IntegerFilter equalTo(int value) {
        setStringValue(getIntValue(value));
        return this;
    }

    public IntegerFilter greaterThan(int value) {
        setRangeValue(getIntValue(value), FilterBuilder.ANY);
        return this;
    }

    private String getIntValue(int value1) {
        if (value1 == Integer.MAX_VALUE) {
            return "*";
        }
        return Integer.toString(value1);
    }

    private String getBigDecimalValue(BigDecimal value) {
        return value.stripTrailingZeros().toPlainString();
    }

}
