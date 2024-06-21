package org.learn.security_course.sql_injection.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
class JdbcController {
    private final JdbcCustomerRepo repo;
    private final CustomerDangerRepo customerDangerRepo;

    @GetMapping("/{email}")
    public ResponseEntity<?> getByMail(@PathVariable String email){
        return ResponseEntity.ok(customerDangerRepo.getByEmail(email));
    }

    @GetMapping("/")
    public ResponseEntity<?> getByGender(@RequestParam String gender){
        return ResponseEntity.ok(repo.findAllByGender(gender));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody JdbcCustomer body){
        var saved = repo.save(body);
        return ResponseEntity.ok(saved);
    }
}
