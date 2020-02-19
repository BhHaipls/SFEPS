package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.OrganizationStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class Organization extends BaseEntity {

    @Column(length = 200)
    private String name;

    @Column(length = 1024)
    private String description;

    @ManyToOne
    private User author;

    @Column
    private int rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 30)
    private OrganizationStatus organizationStatus;

    @ManyToOne
    private OrganizationType organizationType;


    @ManyToMany(mappedBy = "organizations")
    private Set<User> dispatchers;


    @ManyToMany(mappedBy = "organizations")
    private Set<Event> events;

}
