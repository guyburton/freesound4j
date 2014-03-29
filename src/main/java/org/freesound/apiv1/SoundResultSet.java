package org.freesound.apiv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface SoundResultSet {

    @JsonProperty("num_results")
    int getNumResults();

    @JsonProperty("num_pages")
    int getNumPages();

    @JsonProperty
    List<Sound> getSounds();
}
