package cl.duoc.ms_sales_bs.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class WebPayTransactionRequestDTO {

    @JsonProperty("buy_order")
    private String buyOrder;
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("amount")
    private int    amount;
    @JsonProperty("return_url")
    private String returnUrl;
}