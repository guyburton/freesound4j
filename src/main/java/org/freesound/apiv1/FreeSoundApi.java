package org.freesound.apiv1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.mrbean.MrBeanModule;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.message.Attachment;

import javax.ws.rs.*;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * As documented at http://www.freesound.org/docs/api/resources_apiv1.html
 */
public interface FreeSoundApi {
    public final static String URL = "http://www.freesound.org/api";

    /**
     * Retrieves all data for the sound with the specified ID
     * @param soundId The id of the sound to retrieve
     * @param apiKey  The API key to use for the request
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/sounds/{sound_id}/")
    public Sound getSound(@PathParam("sound_id") int soundId, @QueryParam("api_key") String apiKey);

    /**
     * Query freesound.org for sounds
     * @param query The query
     * @param page The page of the search result to get
     * @param filter The filter
     * @param sort How to sort the results
     * @param fields Fields to return
     * @param sounds_per_page Number of sounds to return in each page (be aware that large numbers may produce sloooow queries, maximum allowed is 100 sounds per page)
     * @param apiKey The API key to use for the request
     * @return A paginated list of sounds
     */
    @GET
    @Produces("application/json")
    @Path("/sounds/search/")
    public SoundResultSet search(@QueryParam("q") String query,
                              @QueryParam("p") int page,
                              @QueryParam("f") String filter,
                              @QueryParam("s") Sort sort,
                              @QueryParam("fields") String fields,
                              @QueryParam("sounds_per_page") int sounds_per_page,
                              @QueryParam("api_key") String apiKey);

    /**
     * Query freesound.org for sounds
     * @param query The query
     * @param apiKey The API key to use for the request
     * @return A paginated list of sounds
     */
    @GET
    @Produces("application/json")
    @Path("/sounds/search/")
    public SoundResultSet search(@QueryParam("q") String query, @QueryParam("api_key") String apiKey);

    @GET
    @Path("/sounds/{soundId}/serve/")
    @Produces("multipart/mixed")
    @Multipart(value = "root", type = "application/octet-stream")
    public InputStream download(@PathParam("soundId") int soundId, @QueryParam("api_key") String apiKey);

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
