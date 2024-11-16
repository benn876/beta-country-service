package org.beta.country.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

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

    @OneToOne(cascade = ALL)
    private President president;

    @OneToMany(cascade = ALL)
    private List<City> cities;

//    @ManyToOne
//    private List<Continent> continent;

//    @ManyToMany
//    private List<Country> neighbours;

}
