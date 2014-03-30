package org.freesound.apiv1.filter;

public enum FilterField {
    Id("id"),
    Username("username"),
    Created("created"),
    OriginalFilename("original_filename"),
    Description("description"),
    Tag("tag"),
    License("license"); // one of (“Attribution”, “Attribution Noncommercial” or “Creative Commons 0”)

    private final String description;

    FilterField(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
