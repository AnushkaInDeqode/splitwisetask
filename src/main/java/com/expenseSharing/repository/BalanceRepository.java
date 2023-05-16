package com.expenseSharing.repository;

import com.expenseSharing.model.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, String> {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BalanceRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void updateBalance(String payerId, String ownerId, double amount) {
//        String sql = "UPDATE balance SET amount = amount + ? WHERE payer_id = ? AND owner_id = ?";
//        jdbcTemplate.update(sql, amount, payerId, ownerId);
//    }
}
