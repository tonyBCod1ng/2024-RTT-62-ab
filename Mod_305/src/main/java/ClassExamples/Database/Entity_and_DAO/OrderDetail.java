package ClassExamples.Database.Entity_and_DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private Integer id;
   @Column(name = "order_id")
    private Integer orderID;
   @Column(name = "product_id")
    private Integer productID;
   @Column(name = "quantity_ordered")
    private Integer quantityOrdered;
   @Column(name = "price_each")
    private BigDecimal priceEach;
   @Column(name = "order_line_number")
    private Short orderLineNumber;

}
