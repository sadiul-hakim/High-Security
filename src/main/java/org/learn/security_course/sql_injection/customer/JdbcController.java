package org.learn.security_course.sql_injection.customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Validated
class JdbcController {
    private final JdbcCustomerRepo repo;
    private final CustomerDangerRepo customerDangerRepo;

    @GetMapping("/{email}")
    public ResponseEntity<?> getByMail(@Email @PathVariable String email){
        return ResponseEntity.ok(customerDangerRepo.getByEmail(email));
    }

    @GetMapping("/")
    public ResponseEntity<?> getByGender(@Pattern(regexp = "^[MF]$",message = "Invalid Gender") @RequestParam String gender){
        return ResponseEntity.ok(repo.findAllByGender(gender));
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody JdbcCustomer body){
        var saved = repo.save(body);
        return ResponseEntity.ok(saved);
    }
}
