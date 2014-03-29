package org.freesound.apiv1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface User {

    @JsonProperty
    String getUsername();

    @JsonProperty
    String getUrl();

    @JsonProperty
    String getRef();

}
