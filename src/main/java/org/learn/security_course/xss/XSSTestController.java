package org.learn.security_course.xss;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/xss/danger/api")
public class XSSTestController {

    @CrossOrigin("*")
    @GetMapping(value = "/greet/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> greet(@PathVariable String name) {
        return ResponseEntity.ok("Hello, " + name);
    }

    @CrossOrigin("*")
    @GetMapping("/file")
    public Resource getFile(){
        return new ClassPathResource("static/xss.csv");
    }
}
