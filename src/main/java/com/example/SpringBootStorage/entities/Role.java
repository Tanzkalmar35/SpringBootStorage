package com.example.SpringBootStorage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    // Change to long
    private UUID uuid;

    @Column(nullable = false, unique = true, name = "name")
    @Enumerated(EnumType.STRING)
    private RoleName name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "role_storage_data",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "data_id")
    )
    private Set<StorageDataEntry> storageDataEntries;


    public Role(final UUID uuid, final RoleName name, final Set<User> users, final Set<StorageDataEntry> storageDataEntries) {
        this.uuid = uuid;
        this.name = name;
        this.users = users;
        this.storageDataEntries = storageDataEntries;
    }

    public Role() {}

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(final RoleName name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(final Set<User> users) {
        this.users = users;
    }

    public Set<StorageDataEntry> getStorageDataEntries() {
        return storageDataEntries;
    }

    public void setStorageDataEntries(final Set<StorageDataEntry> storageDataEntries) {
        this.storageDataEntries = storageDataEntries;
    }

    public enum RoleName {
        ADMIN
    }
}
