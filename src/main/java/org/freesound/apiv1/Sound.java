package org.freesound.apiv1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

    @JsonProperty
    User getUser();
}
