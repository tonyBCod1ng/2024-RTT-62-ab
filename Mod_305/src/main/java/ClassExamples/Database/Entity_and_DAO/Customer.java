package ClassExamples.Database.Entity_and_DAO;
import jakarta.persistence.TypedQuery;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
class Customer {
    @Id
    @Column(name = "id")
   private Integer id;
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
   private Integer salesRepEmployeeId;
    @Column(name = "credit_limit", columnDefinition = "Decimal")
    private float creditLimit;

}