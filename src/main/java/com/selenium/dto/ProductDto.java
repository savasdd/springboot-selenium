package com.selenium.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.selenium.utils.BaseView;
import com.selenium.utils.enums.ProductType;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductDto {

    @JsonView(BaseView.Public.class)
    private UUID id;

    @JsonView(BaseView.Public.class)
    private String name;

    @JsonView(BaseView.Public.class)
    private Double price;

    @JsonView(BaseView.Public.class)
    private Integer count;

    @JsonView(BaseView.Public.class)
    private ProductType type;

    @JsonView(BaseView.Public.class)
    private Long version;

    //private Double tax;

}
