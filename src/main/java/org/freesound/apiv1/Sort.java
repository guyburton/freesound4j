package org.freesound.apiv1;

public enum Sort {
    score, //	Sort by a relevance score returned by our search engine (default).
    duration_desc, //	Sort by the duration of the sounds, longest sounds first.
    duration_asc, //	Same as above, but shortest sounds first.
    created_desc, //	Sort by the date of when the sound was added. newest sounds first.
    created_asc, //	Same as above, but oldest sounds first.
    downloads_desc, //	Sort by the number of downloads, most downloaded sounds first.
    downloads_asc, //	Same as above, but least downloaded sounds first.
    rating_desc, //	Sort by the average rating given to the sounds, highest rated first.
    rating_asc, //	Same as above, but lowest rated sounds first.
}
