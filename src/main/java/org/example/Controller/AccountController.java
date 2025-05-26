package org.example.Controller;

import org.example.Model.Account;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        // Здесь будет логика получения счета по ID
        return new Account();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        // Логика создания нового счета
        return account;
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
        // Обновление данных о счете
        accountDetails.setId(id);
        return accountDetails;
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        // Удаление счета
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        // Получение всех счетов
        return List.of(new Account());
    }
}