package com.example.SpringBootStorage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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

    @OneToMany(mappedBy = "storageDataEntry")
    private Set<Property> properties;

    @JsonIgnore
    @ManyToMany(mappedBy = "storageDataEntries")
    private Set<Role> rolesWithPermission;

    public StorageDataEntry() {}

    public StorageDataEntry(
            final UUID uuid,
            final String name,
            final Set<Property> properties,
            final Set<Role> rolesWithPermission) {

        this.uuid = uuid;
        this.name = name;
        this.properties = properties;
        this.rolesWithPermission = rolesWithPermission;
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

    public Set<Role> getRolesWithPermission() {
        return rolesWithPermission;
    }

    public void setRolesWithPermission(final Set<Role> rolesWithPermission) {
        this.rolesWithPermission = rolesWithPermission;
    }

    public void addRoleWithPermission(final Role role) {
        this.rolesWithPermission.add(role);
    }

    public void removeRoleWithPermission(final Role role) {
        this.rolesWithPermission.remove(role);
    }
}
