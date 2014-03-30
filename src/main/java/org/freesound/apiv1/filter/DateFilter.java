package org.freesound.apiv1.filter;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import java.text.DateFormat;
import java.util.Date;

public class DateFilter extends Filter {

    public static final DateFormat DATE_FORMAT = new ISO8601DateFormat();

    DateFilter(FilterField currentFilterField) {
        super(currentFilterField);
    }

    public DateFilter isBetween(Date value1, Date value2) {
        setRangeValue(DATE_FORMAT.format(value1), DATE_FORMAT.format(value2));
        return this;
    }

    public DateFilter after(Date value1) {
        setRangeValue(DATE_FORMAT.format(value1), ANY);
        return this;
    }

    public DateFilter before(Date value1) {
        setRangeValue(ANY, DATE_FORMAT.format(value1));
        return this;
    }
}
