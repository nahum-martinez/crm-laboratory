package com.msvc.person.entity;

import com.msvc.person.entity.type.CivilStatusType;
import com.msvc.person.entity.type.SexType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_person", uniqueConstraints = {@UniqueConstraint( name = "idx_identity_code",columnNames = {"identity_code"})})
public class PersonEntity extends AuditEntity {
    @Id
    @Column(name = "id_person", nullable = false, length = 120)
    private String idPerson;

    @NotBlank()
    @Length(min = 13, max = 20)
    @Column(name = "identity_code", columnDefinition = "varchar(20)", nullable = false, length = 20, unique = true)
    private String identityCode;

    @NotBlank()
    @Column(name = "first_name", columnDefinition = "varchar(50)", nullable = false, length = 50)
    private String firstName;

    @NotBlank()
    @Column(name = "last_name", columnDefinition = "varchar(50)", nullable = false, length = 50)
    private String lastName;

    @NotNull()
    @Enumerated(EnumType.STRING)
    @ValidateString(regexp = "NEW|DEFAULT")
    @Column(name = "sex", columnDefinition = "varchar(10)", nullable = false)
    private SexType sex = SexType.MALE;

    @NotNull()
    @Enumerated(EnumType.STRING)
    @Column(name = "civil_status", columnDefinition = "varchar(10)", nullable = false)
    private CivilStatusType civilStatus = CivilStatusType.MARRIED;

    @NotNull()
    @Column(name = "date_birth", columnDefinition = "date")
    private Date date_birth;
}
