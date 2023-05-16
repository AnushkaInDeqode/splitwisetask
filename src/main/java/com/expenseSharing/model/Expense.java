package com.expenseSharing.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payer_id")
    private String payerId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "split_type")
    private String splitType; // Split type as string

}
