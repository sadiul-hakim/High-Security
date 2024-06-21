package org.learn.security_course.sql_injection.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface JdbcCustomerRepo extends JpaRepository<JdbcCustomer, Integer> {

    Optional<JdbcCustomer> findByEmail(String email);
    List<JdbcCustomer> findAllByGender(String gender);
}
