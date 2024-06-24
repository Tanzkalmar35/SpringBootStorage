package com.example.SpringBootStorage.dto;

import com.example.SpringBootStorage.entities.Property;

import java.util.Set;
import java.util.UUID;

public class StorageDataEntryDto {

    private UUID uuid;

    private String name;

    private Set<Property> properties;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(final Set<Property> properties) {
        this.properties = properties;
    }
}
