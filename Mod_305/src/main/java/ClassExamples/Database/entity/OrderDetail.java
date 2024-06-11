package ClassExamples.Database.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private int id;
   @Column(name = "order_id", insertable = false, updatable = false)
    private int orderID;
   @Column(name = "product_id", insertable = false, updatable = false)
    private int productID;
   @Column(name = "quantity_ordered")
    private int quantityOrdered;
    @Column(name = "price_each", columnDefinition = "Decimal", precision = 2)
    private double priceEach = 0.00;

    @Column(name = "order_line_number", columnDefinition = "SMALLINT")
    private int orderLineNumber;

}
