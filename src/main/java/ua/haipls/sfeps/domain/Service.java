package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.ServiceStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@SuperBuilder
public class Service extends BaseEntity {

    @NotBlank
    @Column(length = 100)
    private String name;

    @NotBlank
    @Column(length = 1024)
    private String description;

    @ManyToOne
    @NotBlank
    private User author;

    @NotBlank
    @Column
    private int rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 30)
    private ServiceStatus serviceStatus;

    @ManyToOne
    private ServiceType serviceType;


    @ManyToMany(mappedBy = "services")
    private Set<User> dispatchers;


    @NotBlank
    @ManyToMany(mappedBy = "services")
    private Set<Event> events;

}
