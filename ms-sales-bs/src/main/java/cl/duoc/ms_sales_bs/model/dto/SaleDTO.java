package cl.duoc.ms_sales_bs.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SaleDTO {

    private String           sessionId;
    private LocalDateTime    date;
    private Integer          amount;
    private List<ProductDTO> products;
}
