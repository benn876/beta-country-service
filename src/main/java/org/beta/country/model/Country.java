package org.beta.country.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@With
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String capital;
    @Column
    private Integer population;
    @Column
    private Integer area;
    @Column
    private String continent;

    @Transient
    private List<String> neighbours;
}
