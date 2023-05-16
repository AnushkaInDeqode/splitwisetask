package com.expenseSharing.repository;

import com.expenseSharing.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public UserRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void addUser(User user) {
//        String sql = "INSERT INTO user (user_id, name, email, mobile_number) VALUES (?, ?, ?, ?)";
//        jdbcTemplate.update(sql, user.getUserId(), user.getName(), user.getEmail(), user.getMobileNumber());
//    }
//
//    public User getUserById(String userId) {
//        String sql = "SELECT * FROM user WHERE user_id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) -> {
//            User user = new User();
//            user.setUserId(rs.getString("user_id"));
//            user.setName(rs.getString("name"));
//            user.setEmail(rs.getString("email"));
//            user.setMobileNumber(rs.getString("mobile_number"));
//            return user;
//        });
//    }
}
