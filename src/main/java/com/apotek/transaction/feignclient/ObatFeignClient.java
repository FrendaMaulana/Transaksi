package com.apotek.transaction.feignclient;

import com.apotek.transaction.model.ObatDTO;
import com.apotek.transaction.model.ObatHistory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "obat") // iki isi en sesuai nama app microservice nak eureka e
public interface ObatFeignClient {
    @GetMapping("/obat/list") // Replace "/obat/list" with the actual endpoint in your Obat microservice
    List<ObatDTO> getAllObats();

    @GetMapping("/obat/{id}")
    ObatDTO getObatById(@PathVariable Long id);

    @GetMapping("/obat/history/all") // Replace "/obat/list" with the actual endpoint in your Obat microservice
    List<ObatHistory> getAllObatsHistory();
}
