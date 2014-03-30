package org.freesound.apiv1.filter;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.google.common.base.Joiner;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Non-mandatory utility for constructing filter parameters
 * For example:  FilterBuilder.builder().where(Username.equalTo("James")).build()
 */
public class FilterBuilder {

    public static final StringFilter Username = new StringFilter(FilterField.Username);
    public static final DateFilter Created = new DateFilter(FilterField.Created);
    public static final IntegerFilter Id = new IntegerFilter(FilterField.Id);
    public static final StringFilter OriginalFilename = new StringFilter(FilterField.OriginalFilename);
    public static final StringFilter Description = new StringFilter(FilterField.Description);
    public static final StringFilter Tag = new StringFilter(FilterField.Tag);
    public static final StringFilter License = new StringFilter(FilterField.License);

    private List<Filter> filters = new ArrayList<Filter>();

    private FilterBuilder() {
    }

    public static FilterBuilder builder() {
        return new FilterBuilder();
    }

    public FilterBuilder where(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public String build() {
        return Joiner.on(" ").join(filters);
    }
}
