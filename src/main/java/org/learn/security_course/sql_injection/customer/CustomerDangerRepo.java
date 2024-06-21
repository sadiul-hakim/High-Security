package org.learn.security_course.sql_injection.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerDangerRepo {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCustomer getByEmail(String email){
        return jdbcTemplate.queryForObject("select * from jdbc_customer where email = "+email,this::convertToObject);
    }

    private JdbcCustomer convertToObject(ResultSet rs, int i) throws SQLException {
        var customer = new JdbcCustomer();

        Optional.ofNullable(rs.getDate("birth_date")).ifPresent(b -> customer.setBirthDate(b.toLocalDate()));
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setEmail(rs.getString("email"));
        customer.setFullName(rs.getString("full_name"));
        customer.setGender(rs.getString("gender"));

        return customer;
    }
}
