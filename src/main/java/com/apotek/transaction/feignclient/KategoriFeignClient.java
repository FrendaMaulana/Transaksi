package com.apotek.transaction.feignclient;

import com.apotek.transaction.model.KategoriDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "kategori-service") // iki isi en sesuai nama app microservice nak eureka e
public interface KategoriFeignClient {
    @GetMapping("/kategori/all")
    List<KategoriDTO> getAllKategori();

    @GetMapping("/kategori/{id}")
    KategoriDTO getKategoriById(@PathVariable Integer id);
}
