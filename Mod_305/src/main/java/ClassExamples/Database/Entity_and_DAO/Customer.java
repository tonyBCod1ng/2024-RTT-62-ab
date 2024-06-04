package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private int id;
    @Column(name = "customer_name")
   private String customerName;
    @Column(name = "contact_firstname")
   private String contactFirstname;
    @Column(name = "contact_lastname")
   private String contactLastname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address_line1")
    private String addressLine1;
    @Column(name = "address_line2")
   private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
   private String country;
    @Column(name = "sales_rep_employee_id")
   private int salesRepEmployeeId;
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

}