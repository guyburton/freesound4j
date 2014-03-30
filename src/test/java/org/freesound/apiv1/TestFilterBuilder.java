package org.freesound.apiv1;

import org.freesound.apiv1.filter.FilterBuilder;
import org.junit.Test;

import java.util.Date;

import static org.freesound.apiv1.filter.FilterBuilder.Created;
import static org.freesound.apiv1.filter.FilterBuilder.Username;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestFilterBuilder {

    @Test
    public void equalToProducesCorrectValue() {
        assertThat(
                FilterBuilder.builder().where(Username.equalTo("James")).build(),
                equalTo("username:James"));
    }

    @Test
    public void betweenDatesFormattedCorrectly() {
        assertThat(
                FilterBuilder.builder().where(Created.isBetween(new Date(10000000), new Date(90000000))).build(),
                equalTo("created:[1970-01-01T02:46:40Z TO 1970-01-02T01:00:00Z]"));
    }

    @Test
    public void beforeDateFormattedCorrectly() {
        assertThat(
                FilterBuilder.builder().where(Created.before(new Date(10000000))).build(),
                equalTo("created:[* TO 1970-01-01T02:46:40Z]"));
    }

    @Test
    public void afterDateFormattedCorrectly() {
        assertThat(
                FilterBuilder.builder().where(Created.after(new Date(10000000))).build(),
                equalTo("created:[1970-01-01T02:46:40Z TO *]"));
    }

    @Test
    public void integerEqualTo() {
        assertThat(
                FilterBuilder.builder().where(FilterBuilder.Id.equalTo(2)).build(),
                equalTo("id:2"));
    }

    @Test
    public void integerBetween() {
        assertThat(
                FilterBuilder.builder().where(FilterBuilder.Id.isBetween(1,2)).build(),
                equalTo("id:[1 TO 2]"));
    }

    @Test
    public void integerLessThan() {
        assertThat(
                FilterBuilder.builder().where(FilterBuilder.Id.lessThan(2)).build(),
                equalTo("id:[* TO 2]"));
    }

    @Test
    public void integerGreaterThan() {
        assertThat(
                FilterBuilder.builder().where(FilterBuilder.Id.greaterThan(2)).build(),
                equalTo("id:[2 TO *]"));
    }


}
