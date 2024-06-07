package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private Integer id;
   @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderID;
   @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productID;
   @Column(name = "quantity_ordered")
    private Integer quantityOrdered;
   @Column(name = "price_each", columnDefinition = "Decimal", precision = 2)
    private Double priceEach;
   @Column(name = "order_line_number", columnDefinition = "SMALLINT")
    private Integer orderLineNumber;

}
