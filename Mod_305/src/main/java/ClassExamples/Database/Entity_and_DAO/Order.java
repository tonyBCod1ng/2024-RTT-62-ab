package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
 class Order {
    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "customer_id", insertable = false, updatable = false)
    private Integer customerId;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "required_date")
    @Temporal(TemporalType.DATE)
    private Date requiredDate;
    @Column(name = "status")
    private String status;
    @Column(name = "comments", columnDefinition = "Text")
    private String comment;

}
