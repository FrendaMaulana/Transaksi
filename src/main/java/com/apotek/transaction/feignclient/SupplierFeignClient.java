package com.apotek.transaction.feignclient;
import com.apotek.transaction.model.SupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "supplier-service") // iki isi en sesuai nama app microservice nak eureka e
public interface SupplierFeignClient {
    @GetMapping("/supplier/all") //
    List<SupplierDTO> getAllSupplier();

    @GetMapping("/supplier/{id}")
    SupplierDTO getSupplierById(@PathVariable Integer id);
}
