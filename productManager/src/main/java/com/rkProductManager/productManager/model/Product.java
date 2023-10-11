package com.rkProductManager.productManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="prd_tab")
public class Product {

    @GeneratedValue  //to generate the id
    @Id  //generate auto id
    @Column(name = "p_id")
    private Integer prodId;

    @Column(name = "p_code")
    private String prodCode;

    @Column(name = "p_cost")
    private Double prodCost;

    @Column(name = "p_ven")
    private String prodVendor;

    @Column(name = "p_gst")
    private Double prodGst;

    @Column(name = "p_dis")
    private Double prodDis;
}
