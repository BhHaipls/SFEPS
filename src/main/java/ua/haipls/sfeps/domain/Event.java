package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.EventStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Data
@SuperBuilder
@Entity
public class Event extends BaseEntity {
    @Column(length = 90)
    private String name;

    @Column(length = 512)
    private String description;

    @Column
    private LocalDate date;

    @NotBlank
    @Column(length = 256)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EventStatus status;

    @ManyToOne
    @NotBlank
    private ImportantEvent important;

    @ManyToOne
    @NotBlank
    private User author;


    @NotBlank
    @ManyToMany
    private Set<Service> services;


    @OneToMany(mappedBy = "event",orphanRemoval = true)
    @NotBlank
    private Set<Comment> comments;

}
