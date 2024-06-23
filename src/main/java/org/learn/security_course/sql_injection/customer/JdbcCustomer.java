package org.learn.security_course.sql_injection.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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
    @GeneratedValue
    private int customerId;
    @Column(name = "full_name")
    private String fullName;

    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Pattern(regexp = "^[MF]$",message = "Invalid gender")
    @Column(name = "gender")
    private String gender;
}
