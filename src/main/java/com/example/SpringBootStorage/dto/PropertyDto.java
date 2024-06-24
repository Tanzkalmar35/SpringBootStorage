package com.example.SpringBootStorage.dto;

import com.example.SpringBootStorage.entities.Property;

import java.util.UUID;

public class PropertyDto {

    private UUID uuid;

    private String key;

    private String value;

    private Property.DataType type;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public Property.DataType getType() {
        return type;
    }

    public void setType(final Property.DataType type) {
        this.type = type;
    }
}
