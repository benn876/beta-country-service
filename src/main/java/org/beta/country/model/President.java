package org.beta.country.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@With
public class President {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String countryId;
}
