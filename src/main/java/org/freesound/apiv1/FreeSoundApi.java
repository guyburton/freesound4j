package org.freesound.apiv1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.mrbean.MrBeanModule;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import javax.ws.rs.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public interface FreeSoundApi {
    public final static String URL = "http://www.freesound.org/api";

    @GET
    @Produces("application/json")
    @Path("/sounds/{sound_id}/")
    public Sound getSound(@PathParam("sound_id") int soundId, @QueryParam("api_key") String apiKey);

    public static final class Factory {

        /**
         * Create an instance of the API
         * @return
         */
        public static FreeSoundApi create() {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new MrBeanModule());
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

            List<Object> providers = new ArrayList();
            providers.add(new JacksonJsonProvider(objectMapper, JacksonJsonProvider.BASIC_ANNOTATIONS));
            return JAXRSClientFactory.create(URL, FreeSoundApi.class, providers);
        }
    }
}
