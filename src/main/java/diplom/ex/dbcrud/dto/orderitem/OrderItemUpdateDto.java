package diplom.ex.dbcrud.dto.orderitem;

import diplom.ex.dbcrud.dto.product.ProductDto;
import diplom.ex.dbcrud.models.Order;
import diplom.ex.dbcrud.models.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class OrderItemUpdateDto {
    private int number;
    private BigDecimal price;
    private ProductDto product;
}
