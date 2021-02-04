package com.cacuware.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PPE {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    @Column
    private String size;

//    @Column
//    private PPEType type;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ElementCollection
    @CollectionTable(name = "ppe_peopleids", joinColumns = @JoinColumn(name = "ppe_id", referencedColumnName = "id"))
    private List<UUID> person_id;
}
