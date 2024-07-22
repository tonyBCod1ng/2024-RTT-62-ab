package com.example.springBoot.form;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
public class CreateProductFormBean {

    private Integer id;
    private String productCode;
    private String productName;
    private Integer productlineId;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    private Double msrp;

}
