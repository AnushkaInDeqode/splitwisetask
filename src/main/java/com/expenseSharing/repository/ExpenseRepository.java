package com.expenseSharing.repository;

import com.expenseSharing.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // ...

    @Modifying
    @Query("DELETE FROM Expense e WHERE e.id = :expenseId")
    void deleteExpenseById(@Param("expenseId") Long expenseId);

    @Modifying
    @Query("DELETE FROM Expense e WHERE e.id = :expenseId AND e.payerId = :userId")
    void deleteExpenseByIdAndPayerId(@Param("expenseId") Long expenseId, @Param("userId") String userId);

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public ExpenseRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void addExpense(Expense expense) {
//        String sql = "INSERT INTO expense (expense_id, payer_id, total_amount, split_type) VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(sql, expense.getExpenseId(), expense.getPayerId(), expense.getTotalAmount(), expense.getSplitType().toString());
//    }
//
//    public Expense getExpenseById(long expenseId) {
//        String sql = "SELECT * FROM expenses WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{expenseId}, new ExpenseRowMapper());
//    }
}