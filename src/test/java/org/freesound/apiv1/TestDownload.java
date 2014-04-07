package org.freesound.apiv1;

import org.apache.cxf.message.Attachment;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
            assertTrue(download.available() > 100000);
        } finally {
            download.close();
        }
    }

}
