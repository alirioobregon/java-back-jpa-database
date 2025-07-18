package com.example.ali.java_back_jpa_database.entities;

import com.example.ali.java_back_jpa_database.entities.response.ResponseGeneric;
import com.example.ali.java_back_jpa_database.validation.ExistByUsername;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends ResponseGeneric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUser;

    @ExistByUsername
    @NotBlank
    @Size(min = 4)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min = 4)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Boolean enabled = true;

    @Transient
    private boolean admin;

    @JsonIgnoreProperties({"users", "handler", "hibernateLazyInitializer"})
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id_user", "id_role"})}
    )
    private List<Role> roles;

    public User() {
        roles = new ArrayList<>();
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(idUser, user.idUser) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, username);
    }
}
