package dev.priyanshuvishnoi.springsecurityjwt.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements Serializable {
    @Id
    @GeneratedValue
    private Short roleId;

    @Column(nullable = false, unique = true)
    private String roleName;
}
