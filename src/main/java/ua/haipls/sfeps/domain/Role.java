package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class Role extends BaseEntity {

    @Column(length = 20,unique = true)
    private String name;


}
