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
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private Company company;

    @Column
    private boolean isDeleted;

    @ElementCollection
    @CollectionTable(name = "project_peopleids", joinColumns = @JoinColumn(name = "ppe_id", referencedColumnName = "id"))
    private List<UUID> people;

    @ElementCollection
    @CollectionTable(name = "project_fileids", joinColumns = @JoinColumn(name = "ppe_id", referencedColumnName = "id"))
    private List<UUID> files;

    @ElementCollection
    @CollectionTable(name = "project_carids", joinColumns = @JoinColumn(name = "ppe_id", referencedColumnName = "id"))
    private List<UUID> cars;

    @ElementCollection
    @CollectionTable(name = "project_materialids", joinColumns = @JoinColumn(name = "ppe_id", referencedColumnName = "id"))
    private List<UUID> materials;

}
