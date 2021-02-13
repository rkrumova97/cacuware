package com.cacuware.warehouse.model;

import com.cacuware.warehouse.mapper.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    private String measurement;

    @Column
    private String quantity;

    @Column(name = "single_price")
    private Integer singlePrice;

    @Column
    private Integer value;

    @Column(name = "income_invoice_number")
    private Integer incomeInvoiceNumber;

    @Column(name = "money_spent")
    private Integer moneySpent;

    @Column(name = "outcome_invoice_number")
    private Integer outcomeInvoiceNumber;

    @Column(columnDefinition = "DATE")
    @Convert(converter = DateConverter.class)
    private LocalDate date;

    @Column(name = "material_left")
    private Float left;

    @Column
    private String type;

    @Column
    private boolean isDeleted;
}
