package ua.haipls.sfeps.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
public class Role extends BaseEntity {

    @NotBlank
    @Column(length = 20,unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
