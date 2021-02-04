package com.cacuware.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "number")
    private String number;

    @Column(name = "engine_volume")
    private String engineVolume;

    @Column
    private String insurance;

    @Column(name = "insurance_expiry_date")
    private LocalDate insuranceExpiryDate;

    @Column
    private String examination;

    @Column(name = "examination_expiry_date")
    private LocalDate examinationExpiryDate;

    @Column
    private String vignette;

    @Column(name = "vignette_expiry_date")
    private LocalDate vignetteExpiryDate;

    @Column
    private String repair;

    @Column(name = "repair_date")
    private LocalDate repairDate;

    @Column(name = "repair_money")
    private Integer repairMoney;

    @Column
    private Integer kilometers;

    @Column
    private Double fuel;

    @Column
    private Integer norm;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ElementCollection
    @CollectionTable(name = "car_materialids", joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
    private List<UUID> material_id;

}


