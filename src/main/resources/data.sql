-- Sample data for User entity
INSERT INTO user (user_id, name, email, mobile_number) VALUES ('u1', 'User1', 'user1@example.com', '1234567890');
INSERT INTO user (user_id, name, email, mobile_number) VALUES ('u2', 'User2', 'user2@example.com', '9876543210');
INSERT INTO user (user_id, name, email, mobile_number) VALUES ('u3', 'User3', 'user3@example.com', '5555555555');
INSERT INTO user (user_id, name, email, mobile_number) VALUES ('u4', 'User4', 'user4@example.com', '9999999999');

-- Sample data for Expense entity
INSERT INTO expense (expense_id, payer_id, total_amount, split_type) VALUES (1, 'u1', 1000, 'EQUAL');
INSERT INTO expense (expense_id, payer_id, total_amount, split_type) VALUES (2, 'u1', 1250, 'EXACT');

-- Sample data for Balance entity
INSERT INTO balance (payer_id, ower_id, amount) VALUES ('u1', 'u2', 250);
INSERT INTO balance (payer_id, ower_id, amount) VALUES ('u1', 'u3', 250);
INSERT INTO balance (payer_id, ower_id, amount) VALUES ('u1', 'u4', 250);
