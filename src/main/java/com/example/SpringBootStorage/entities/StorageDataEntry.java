package com.example.SpringBootStorage.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "storage_data")
public class StorageDataEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID uuid;

    @Column(nullable = false, name = "name")
    private String name;

    @OneToMany(mappedBy = "storage_data_entry_uuid")
    private Set<Property> properties;

    // TODO: Add user field

    public StorageDataEntry() {}

    public StorageDataEntry(final UUID uuid, final String name, final Set<Property> properties) {
        this.uuid = uuid;
        this.name = name;
        this.properties = properties;
    }

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
