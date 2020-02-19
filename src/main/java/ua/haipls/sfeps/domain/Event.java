package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.haipls.sfeps.domain.domainEnum.EventStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
public class Event extends BaseEntity {
    @Column(length = 90)
    private String name;

    @Column(length = 2054)
    private String description;

    @Column
    private LocalDateTime date;

    @Column(length = 256)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private EventStatus status;

    @ManyToOne
    private ImportantEvent important;

    @ManyToOne
    private User author;

    @ManyToMany
    private Set<Organization> organizations;


    @OneToMany(mappedBy = "event",orphanRemoval = true)
    private Set<Comment> comments;

}
