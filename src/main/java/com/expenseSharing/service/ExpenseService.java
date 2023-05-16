package com.expenseSharing.service;

import com.expenseSharing.model.Balance;
import com.expenseSharing.model.Expense;
import com.expenseSharing.model.SplitType;
import com.expenseSharing.model.User;
import com.expenseSharing.repository.BalanceRepository;
import com.expenseSharing.repository.ExpenseRepository;
import com.expenseSharing.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, BalanceRepository balanceRepository,
                          UserRepository userRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.balanceRepository = balanceRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void addExpense(String payerId, BigDecimal amount, SplitType splitType,
                           List<String> participantIds, List<BigDecimal> exactAmounts) {
        Expense expense = new Expense();
        expense.setPayerId(payerId);
        expense.setAmount(amount);
        expense.setSplitType(splitType.name());

        Map<String, BigDecimal> owedAmounts = new HashMap<>();

        if (splitType == SplitType.EQUAL) {
            BigDecimal perPersonAmount = amount.divide(BigDecimal.valueOf(participantIds.size()), 2, RoundingMode.HALF_UP);

            for (String participantId : participantIds) {
                owedAmounts.put(participantId, perPersonAmount);
            }
        } else if (splitType == SplitType.EXACT) {
            if (participantIds.size() != exactAmounts.size()) {
                throw new IllegalArgumentException("Number of participants and amounts must match");
            }

            for (int i = 0; i < participantIds.size(); i++) {
                String participantId = participantIds.get(i);
                BigDecimal exactAmount = exactAmounts.get(i);
                owedAmounts.put(participantId, exactAmount);
            }
        }

        List<Balance> balances = new ArrayList<>();
        BigDecimal updatedBalance = null;
        for (Map.Entry<String, BigDecimal> entry : owedAmounts.entrySet()) {
            String participantId = entry.getKey();
            BigDecimal owedAmount = entry.getValue();

            User user = userService.getUserById(participantId);

            Balance balance = new Balance();
            balance.setUser(user);
            balance.setExpense(expense);
            balances.add(balance);
            BigDecimal updatedAmmount = null;
            for (Balance userBalance : user.getBalances()) {
                updatedAmmount = updatedBalance.subtract(owedAmount);
            }
            user.setBalances((List<Balance>) updatedAmmount);
        }

        expense.setAmount(updatedBalance);
        expenseRepository.save(expense);
        balanceRepository.saveAll(balances);
        userRepository.saveAll(balances.stream().map(Balance::getUser).collect(Collectors.toList()));
    }
}
