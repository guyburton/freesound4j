package org.freesound.apiv1;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class TestSearch {

    @Test
    public void executesQuery() {
        FreeSoundApi api = FreeSoundApi.Factory.create();
        SoundResultSet test = api.search("test", 0, "", Sort.created_asc, "", 5, TestApiKey.API_KEY);

        assertThat(test.getNumResults(), greaterThan(0));
        assertThat(test.getNumPages(), greaterThan(0));
        assertThat(test.getSounds(), hasSize(5));
    }
}
