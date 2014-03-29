package org.freesound.apiv1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface Sound {

    @JsonProperty
    int getId();

    @JsonProperty
    String getUrl();

    @JsonProperty("original_filename")
    String getOriginalFilename();

    @JsonProperty("preview-hq-mp3")
    String getPreviewHighQuality();

    @JsonProperty("waveform_m")
    String getWaveformMedium();

    @JsonProperty("waveform_l")
    String getWaveformLarge();

    @JsonProperty("spectral_m")
    String getSpectralMedium();

    @JsonProperty("spectral_l")
    String getSpectralLarge();

    @JsonProperty
    String getType();

    @JsonProperty
    BigDecimal getDuration();

    @JsonProperty("samplerate")
    int getSampleRate();

    @JsonProperty("bitdepth")
    int getBitDepth();

    @JsonProperty("filesize")
    int getFileSize();

    @JsonProperty
    int getChannels();

    @JsonProperty
    User getUser();

    @JsonProperty
    Date getCreated();

    @JsonProperty
    GeoTag getGeoTag();
}
