package ClassExamples.Database.entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customers")
public class Customer {
    @ToString.Exclude
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_rep_employee_id", nullable = false)
    private Employee employee;
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
    @Column(name = "sales_rep_employee_id", insertable = false, updatable = false)
   private Integer salesRepEmployeeId;
    @Column(name = "credit_limit", columnDefinition = "Decimal")
    private Double creditLimit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(customerName, customer.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName);
    }
}