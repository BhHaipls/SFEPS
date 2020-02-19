package ua.haipls.sfeps.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.UserStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
public class User extends  BaseEntity{

    @Column(name = "first_name",length = 30)
    private String firstName;

    @Column(name = "last_name",length = 30)
    private String secondName;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(updatable = false, unique=true,length = 50)
    @Email
    private String email;

    @Column(length = 256)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",length = 30)
    private UserStatus status;

    @Column(name="password", length = 256)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_has_roles",
            joinColumns = {@JoinColumn(name = "user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role", referencedColumnName = "id")})
    private Set<Role> roles;

    @ManyToMany
    private Set<Organization> organizations;
}