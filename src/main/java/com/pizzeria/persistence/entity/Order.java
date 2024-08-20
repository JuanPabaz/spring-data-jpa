package com.pizzeria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order",nullable = false)
    private Integer idOrder;

    @Column(name = "id_customer",length = 15,nullable = false)
    private String idCostumer;

    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDate date;

    @Column(columnDefinition = "DECIMAL(6,2)",nullable = false)
    private Double total;

    @Column(nullable = false,columnDefinition = "CHAR(1)")
    private String method;

    @Column(name = "additional_notes",length = 200)
    private String additionalNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer",referencedColumnName = "id_customer",insertable = false,updatable = false)
    @JsonIgnore
    private Customer customer;

    @OneToMany(targetEntity = OrderItem.class,mappedBy = "order",fetch = FetchType.LAZY)
    @OrderBy("price ASC")
    private List<OrderItem> orderItemList;
}
