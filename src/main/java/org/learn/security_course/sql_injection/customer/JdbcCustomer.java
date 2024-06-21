package org.learn.security_course.sql_injection.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jdbc_customer")
class JdbcCustomer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "gender")
    private String gender;
}
