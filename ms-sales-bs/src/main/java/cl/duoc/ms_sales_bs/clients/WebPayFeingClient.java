package cl.duoc.ms_sales_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import cl.duoc.ms_sales_bs.model.dto.WebPayTransactionQueryResponseDTO;
import cl.duoc.ms_sales_bs.model.dto.WebPayTransactionRequestDTO;
import cl.duoc.ms_sales_bs.model.dto.WebPayTransactionResponseDTO;

@FeignClient(name="api-webpay", url = "https://webpay3gint.transbank.cl/")
public interface WebPayFeignClient {

    @PostMapping(
        value = "/rswebpaytransaction/api/webpay/v1.2/transactions",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    WebPayTransactionResponseDTO generateTransaction(
        @RequestHeader("Tbk-Api-Key-Id") String tbkApiKeyId, 
        @RequestHeader("Tbk-Api-Key-Secret") String tbkApiKeySecret,
        @RequestBody WebPayTransactionRequestDTO webPayTransactionRequestDTO
    );

    @PutMapping(value = "/rswebpaytransaction/api/webpay/v1.2/transactions/{token}")
    String confirmTransaction(@RequestHeader("Tbk-Api-Key-Id") String tbkApiKeyId, 
                            @RequestHeader("Tbk-Api-Key-Secret") String tbkApiKeySecret, 
                            @RequestParam(name = "token") String token);

    @GetMapping(value = "/rswebpaytransaction/api/webpay/v1.2/transactions/{token}")
    WebPayTransactionQueryResponseDTO queryTransaction(@RequestHeader("Tbk-Api-Key-Id") String tbkApiKeyId, 
                                                       @RequestHeader("Tbk-Api-Key-Secret") String tbkApiKeySecret, 
                                                       @RequestParam(name = "token") String token);
    
}
