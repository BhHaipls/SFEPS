package ua.haipls.sfeps.domain;


import lombok.Data;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.UserStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Data
@SuperBuilder
@Entity
public class User extends  BaseEntity{

    @Column(name = "first_name",length = 30)
    private String firstName;

    @Column(name = "last_name",length = 30)
    private String secondName;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @NotBlank
    @Column(updatable = false, unique=true,length = 50)
    @Email
    private String email;

    @NotBlank
    @Column(length = 256)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 30)
    private UserStatus status;

    @NotBlank
    @Transient
    @Column(name="password", length = 32)
    private String password;

    @NotBlank
    @ManyToMany
    private Set<Role> roles;


    @NotBlank
    @ManyToMany
    private Set<Organization> organizations;
}