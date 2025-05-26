package org.example.Controller;

import org.example.Model.Transaction;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        // Получение транзакции по ID
        return new Transaction();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        // Создание новой транзакции
        return transaction;
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transactionDetails) {
        // Обновление транзакции
        transactionDetails.setId(id);
        return transactionDetails;
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        // Удаление транзакции
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        // Получение всех транзакций
        return List.of(new Transaction());
    }
}