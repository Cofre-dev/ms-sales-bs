package cl.duoc.ms_sales_bs.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.duoc.ms_sales_bs.model.dto.SalesDTO;

@FeignClient(name = "ms-sales-db-svc", url = "http://localhost:8080")
public interface SalesDbFeingClients {

    @GetMapping("/api/sales/{id}")
    public ResponseEntity<SalesDTO> findSalesById(@PathVariable Long id);

}