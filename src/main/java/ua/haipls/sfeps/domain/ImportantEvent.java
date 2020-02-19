package ua.haipls.sfeps.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class ImportantEvent extends BaseEntity{

    @Column(length = 48,unique = true)
    private String name;

    @Column(length = 512)
    private String description;

    private int priority;
}
