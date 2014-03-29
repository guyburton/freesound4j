package org.freesound.apiv1;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Requires FreeSound.org to be up!
 * Try curl http://www.freesound.org/api/sounds/83295/?api_key=&lt;YOUR API KEY HERE&gt;
 */
public class TestSoundResource {

    public static final String API_KEY = "YOUR API KEY HERE";
    private static Sound sound;

    @BeforeClass
    public static void doQuery() {
        FreeSoundApi api = FreeSoundApi.Factory.create();
        sound = api.getSound(83295, API_KEY);
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
}
