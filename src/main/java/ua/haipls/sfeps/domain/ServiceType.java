package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@SuperBuilder
@Entity
public class ServiceType extends BaseEntity {

    @Column(length = 48,unique = true)
    @NotBlank
    private String name;

    @Column(length = 512)
    private String description;

    @NotBlank
    private int priority;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;

}
