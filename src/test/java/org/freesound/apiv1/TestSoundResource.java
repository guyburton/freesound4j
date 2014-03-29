package org.freesound.apiv1;

import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Requires FreeSound.org to be up!
 * Try curl http://www.freesound.org/api/sounds/83295/?api_key=&lt;YOUR API KEY HERE&gt;
 */
public class TestSoundResource {

    private static Sound sound;

    @BeforeClass
    public static void doQuery() {
        FreeSoundApi api = FreeSoundApi.Factory.create();
        sound = api.getSound(83295, TestApiKey.API_KEY);
    }

    @Test
    public void checkBasicProperties() {
        assertThat(sound, hasProperty("originalFilename", equalTo("Noisy_Miner_Chick_FeedMe.wav")));
        assertThat(sound, hasProperty("waveformMedium", equalTo("http://www.freesound.org/data/displays/83/83295_29541_wave_M.png")));
    }

    @Test
    public void checkComplexUserProperty() {
        assertThat(sound.getUser(), notNullValue());
        assertThat(sound.getUser(), hasProperty("username", equalTo("digifishmusic")));
    }

    @Test
    public void checkBigDecimalProperty() {
        assertThat(sound.getDuration(), equalTo(new BigDecimal("48.548956916100003")));
    }

    @Test
    public void checkDateProperty() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertThat(sound.getCreated(), equalTo(format.parse("2009-11-13 10:01:01")));
    }
}
