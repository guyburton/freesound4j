package org.freesound.apiv1;

public enum Sort {
    /**
     * Sort by a relevance score returned by our search engine (default).
     */
    Score("score"),

    /**
     * Sort by the duration of the sounds, longest sounds first.
     */
    DurationDesc("duration_desc"),

    /**
     * Same as above, but shortest sounds first.
     */
    DurationAsc("duration_asc"),

    /**
     * Sort by the date of when the sound was added. newest sounds first.
     */
    CreatedDesc("created_desc"),

    /**
     * Same as above, but oldest sounds first.
     */
    CreatedAsc("created_asc"), //

    /**
     * Sort by the number of downloads, most downloaded sounds first.
     */
    DownloadsDesc("downloads_desc"),

    /**
     * Same as above, but least downloaded sounds first.
     */
    DownloadsAsc("downloads_asc"),

    /**
     * Sort by the average rating given to the sounds, highest rated first.
     */
    RatingDesc("rating_desc"),

    /**
     * 	Same as RatingDesc, but lowest rated sounds first.
     */
    RatingAsc("rating_asc");

    private final String description;

    Sort(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
