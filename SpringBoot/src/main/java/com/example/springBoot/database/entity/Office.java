package com.example.springBoot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "offices")
public class Office {
        @Id
        @Column(name = "id")
        private Integer id;
        @Column(name = "city")
        private String city;
        @Column(name = "phone")
        private String phone;
        @Column(name = "address_line1")
        private String addressLine1;
        @Column(name = "country")
        private String country;
        @Column(name = "postal_code")
        private String postalCode;
        @Column(name = "territory")
        private String territory;

}
