package com.cacuware.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
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

    @Column
    private LocalDate date;

    @Column
    private Integer left;

    @Column
    private String type;
}
