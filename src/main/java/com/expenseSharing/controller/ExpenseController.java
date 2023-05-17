package com.expenseSharing.controller;

import com.expenseSharing.model.User;
import com.expenseSharing.service.ExpenseService;
import com.expenseSharing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.expenseSharing.model.ExpenseRequest;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserService userService;

    @PostMapping("/expenses")
    public ResponseEntity<String> addExpense(@RequestBody ExpenseRequest expenseRequest) {
        try {
            expenseService.addExpense(
                    expenseRequest.getPayerId(),
                    expenseRequest.getAmount(),
                    expenseRequest.getExpenseType(),
                    expenseRequest.getParticipants(),
                    expenseRequest.getIndividualAmounts()
            );
            return ResponseEntity.ok("Expense added successfully!!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add expense: " + e.getMessage());
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable String userId) {
        try {
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}