package org.freesound.apiv1;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Requires FreeSound.org to be up!
 * Try curl http://www.freesound.org/api/sounds/165277/?api_key=&lt;YOUR API KEY HERE&gt;
 */
public class TestDownload {

    private static FreeSoundApi api;

    @BeforeClass
    public static void doQuery() {
        api = FreeSoundApi.Factory.create();
    }

    @Test
    public void downloadsFile() throws IOException {
        InputStream download = api.download(165277, TestApiKey.API_KEY);
        try {
            assertThat(download.available(), greaterThan(0));
        } finally {
            download.close();
        }
    }

}
