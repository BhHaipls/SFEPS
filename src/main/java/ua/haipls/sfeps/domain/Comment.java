package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Data
@SuperBuilder
@Entity
public class Comment extends BaseEntity {

    @NotBlank
    @Column(length = 1024)
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User author;

    @Column
    private int rating;


    @ManyToOne
    @NotBlank
    private Event event;

}
