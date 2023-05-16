package com.expenseSharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {
    private String payerId;
    private BigDecimal amount;
    private SplitType expenseType;
    private List<String> participants;
    private List<BigDecimal> individualAmounts;
}
