package com.msvc.user.entity;

import com.msvc.user.entity.type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user", uniqueConstraints = {@UniqueConstraint(name = "idx_email", columnNames = {"email"})})
public class UserEntity extends AuditEntity {
    @Id
    @Column(name = "id")
    private String idUser;

    @Length(message = "Length is not valid", min = 10, max = 100)
    @NotNull(message = "Email is mandatory")
    @Column(name = "email", columnDefinition = "varchar(100)", length = 100, nullable = false, unique = true)
    private String email;

    @Length(message = "Length is not valid", min = 8, max = 30)
    @NotNull(message = "Password is mandatory")
    @Column(name = "password", columnDefinition = "varchar(30)", length = 30, nullable = false)
    private String password;

    @Column(name = "is_admin", columnDefinition = "boolean default false")
    private Boolean isAdmin = false;

    @Column(name = "ip_address", columnDefinition = "varchar(150)", length = 150)
    private String ipAddress;

    @Column(name = "is_online", columnDefinition = "boolean default false")
    private boolean isOnline = false;

    @NotNull(message = "Role is mandatory")
    @Column(name = "role", columnDefinition = "varchar(20)", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    // Relations
    // @Transient
    // private List<QualificationModel> qualifications = new ArrayList<>();
}
