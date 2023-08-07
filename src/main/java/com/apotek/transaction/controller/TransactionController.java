package com.apotek.transaction.controller;

import com.apotek.transaction.feignclient.KategoriFeignClient;
import com.apotek.transaction.feignclient.ObatFeignClient;
import com.apotek.transaction.feignclient.SupplierFeignClient;
import com.apotek.transaction.feignclient.UserFeignClient;
import com.apotek.transaction.model.*;
import com.apotek.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    private final UserFeignClient userFeignClient;
    private final ObatFeignClient obatFeignClient;
    private final KategoriFeignClient kategoriFeignClient;
    private final SupplierFeignClient supplierFeignClient;

    @Autowired
    public TransactionController(UserFeignClient userFeignClient,
                                 TransactionService transactionService,
                                 ObatFeignClient obatFeignClient,
                                 KategoriFeignClient kategoriFeignClient,
                                 SupplierFeignClient supplierFeignClient) {
        this.transactionService = transactionService;
        this.obatFeignClient = obatFeignClient;
        this.kategoriFeignClient = kategoriFeignClient;
        this.supplierFeignClient = supplierFeignClient;
        this.userFeignClient = userFeignClient;
    }

//  Transaksi Controller
    @GetMapping("/all")
    public List<TransactionDTO> getAllTransactions() {

        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionDTO getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/add")
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.createTransaction(transactionDTO);
    }

    @PutMapping("/edit/{id}")
    public TransactionDTO updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        return transactionService.updateTransaction(id, transactionDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }

//    User Controller
    @GetMapping("/user")
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userFeignClient.getAllUsers();
        return users;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        UserDTO users = userFeignClient.getUserById(id);
        return users;
    }

//  Obat Controller
    @GetMapping("/obat")
    public List<ObatDTO> getAllObats() {
        // Fetch the Obat data from the Obat microservice
        List<ObatDTO> obats = obatFeignClient.getAllObats();
        return obats;
    }

    @GetMapping("/obat/{id}")
    public ObatDTO getObatById(@PathVariable Long id) {
        // Fetch the Obat data from the Obat microservice
        ObatDTO obats = obatFeignClient.getObatById(id);
        return obats;
    }

    @GetMapping("/obat/history")
    public List<ObatHistory> getAllObatsHistory() {
        // Fetch the Obat data from the Obat microservice
        List<ObatHistory> obats = (List<ObatHistory>) obatFeignClient.getAllObatsHistory();
        return obats;
    }

//  Supplier Controller
    @GetMapping("/supplier")
    public List<SupplierDTO> getAllSupplier() {
        // Fetch the Obat data from the Obat microservice
        List<SupplierDTO> supplier = supplierFeignClient.getAllSupplier();
        return supplier;
    }

    @GetMapping("/supplier/{id}")
    public SupplierDTO getSupplierById(@PathVariable Integer id) {
        // Fetch the Obat data from the Obat microservice
        SupplierDTO supplier = supplierFeignClient.getSupplierById(id);
        return supplier;
    }

//  Kategori Controller
    @GetMapping("/kategori")
    public List<KategoriDTO> getAllKategoti() {
        // Fetch the Kategori data from the Obat microservice
        List<KategoriDTO> kategories = kategoriFeignClient.getAllKategori();
        return kategories;
    }

    @GetMapping("/kategori/{id}")
    public KategoriDTO getKategoriById(@PathVariable Integer id) {
        // Fetch the Kategori data from the Obat microservice
        KategoriDTO kategories = kategoriFeignClient.getKategoriById(id);
        return kategories;
    }
}
