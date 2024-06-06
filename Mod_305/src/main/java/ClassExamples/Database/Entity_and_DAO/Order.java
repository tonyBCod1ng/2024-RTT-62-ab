package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "required_date")
    @Temporal(TemporalType.DATE)
    private Date requiredDate;
    @Column(name = "status")
    private String status;
    @Column(name = "comments",columnDefinition = "Text")
    private String comment;

}
