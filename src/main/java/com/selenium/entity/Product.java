package com.selenium.entity;

import com.selenium.utils.enums.ProductType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "COUNT")
    private Integer count;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Version
    @Column(name = "VERSION")
    private Long version;

//    @Formula("price * count")
//    private Double tax;

}
