package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "role", unique = true)
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Проверка на идентичность
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на null и класс
        Role role1 = (Role) obj; // Приведение типа
        return id == role1.id; // Сравнение по id
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id); // Генерация хэш-кода на основе id
    }

    @Override
    public String getAuthority() {
        return this.role;
    }

    public String getReadableRole(String role) {
        if ("ROLE_ADMIN".equals(role)) {
            return "ADMIN";
        }
        if ("ROLE_USER".equals(role)) {
            return "USER";
        }
        if ("ROLE_GUEST".equals(role)) {
            return "GUEST";
        }
        return role;
    }
}
