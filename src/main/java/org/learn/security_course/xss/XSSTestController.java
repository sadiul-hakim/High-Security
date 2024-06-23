package org.learn.security_course.xss;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/xss/danger/api")
@Validated
public class XSSTestController {

    @CrossOrigin("*")
    @GetMapping(value = "/greet/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> greet(@PathVariable @Valid @Pattern(regexp = "[A-Za-z]{5,20}") String name) {
        return ResponseEntity.ok("Hello, " + name);
    }

    @CrossOrigin("*")
    @GetMapping("/file")
    public Resource getFile(){
        return new ClassPathResource("static/xss.csv");
    }
}
