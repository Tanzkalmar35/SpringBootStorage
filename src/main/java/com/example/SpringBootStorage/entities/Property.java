package com.example.SpringBootStorage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID uuid;

    @Column(nullable = false, name = "key")
    private String key;

    @Column(nullable = false, name = "value")
    private String value;

    @Column(nullable = false, name = "type")
    @Enumerated
    private DataType type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "storage_data_entry_uuid", referencedColumnName = "id")
    private StorageDataEntry storageDataEntry;

    public Property(
            final UUID uuid,
            final String key,
            final String value,
            final DataType type,
            final StorageDataEntry storageDataEntry) {

        this.uuid = uuid;
        this.key = key;
        this.value = value;
        this.type = type;
        this.storageDataEntry = storageDataEntry;
    }

    public Property() {}

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

    public DataType getType() {
        return type;
    }

    public void setType(final DataType type) {
        this.type = type;
    }

    public StorageDataEntry getStorageDataEntry() {
        return storageDataEntry;
    }

    public void setStorageDataEntry(final StorageDataEntry storageDataEntry) {
        this.storageDataEntry = storageDataEntry;
    }

    public enum DataType {
        password,
        text
    }
}
