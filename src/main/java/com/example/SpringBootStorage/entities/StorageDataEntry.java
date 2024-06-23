package com.example.SpringBootStorage.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "storage_data")
public class StorageDataEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID uuid;

    @Column(nullable = false, name = "data")
    private String data;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "type")
    private DataType type;

    // TODO: Add user field

    public StorageDataEntry() {}

    public StorageDataEntry(final UUID uuid, final String data, final String name, final DataType type) {
        this.uuid = uuid;
        this.data = data;
        this.name = name;
        this.type = type;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public DataType getType() {
        return type;
    }

    public void setType(final DataType type) {
        this.type = type;
    }

    public enum DataType {
        PASSWORD,
        TELEPHONE_NUMBER,
        OTHER
    }
}
