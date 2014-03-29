package org.freesound.apiv1;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface GeoTag {

    @JsonProperty
    String getLattitude();

    @JsonProperty
    String getLongitude();
}
