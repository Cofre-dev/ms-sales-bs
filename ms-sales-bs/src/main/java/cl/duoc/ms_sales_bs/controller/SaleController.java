package cl.duoc.ms_sales_bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_sales_bs.model.dto.SaleDTO;
import cl.duoc.ms_sales_bs.model.dto.SalesDTO;
import cl.duoc.ms_sales_bs.model.dto.WebPayTransactionDTO;
import cl.duoc.ms_sales_bs.model.dto.WebPayTransactionQueryResponseDTO;
import cl.duoc.ms_sales_bs.model.dto.WebPayTransactionResponseDTO;
import cl.duoc.ms_sales_bs.service.SaleService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/sales")
@Log4j2
public class SaleController {

    @Autowired
    SaleService saleService;
    
    @GetMapping("/{id}")
    public ResponseEntity<SalesDTO> findSalesById(@PathVariable Long id) {
        SalesDTO salesDTO = saleService.findSalesById(id);
        return (salesDTO != null)?  new ResponseEntity<>(salesDTO, HttpStatus.OK) :
                                     new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }

    @PostMapping("")
    public WebPayTransactionResponseDTO createSale(@RequestBody SaleDTO saleDTO) {
        log.error("SaleDTO: {}", saleDTO);
        return saleService.createSale(saleDTO);
    }

    @PostMapping("/transaction/confirm")
    public String confirmTransaction(@RequestBody WebPayTransactionDTO webPayTransacionDTO) {
        log.info("WebPayTransacionDTO: {}", webPayTransacionDTO);
        return saleService.confirmTransaction(webPayTransacionDTO);
    }

    @PostMapping("/transaction/query")
    public WebPayTransactionQueryResponseDTO queryTransaction(@RequestBody WebPayTransactionDTO webPayTransacionDTO) {
        log.info("WebPayTransacionDTO: {}", webPayTransacionDTO);
        return saleService.queryTransaction(webPayTransacionDTO);
    }
    
}