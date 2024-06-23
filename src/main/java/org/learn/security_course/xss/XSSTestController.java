package org.learn.security_course.xss;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.owasp.encoder.Encode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/xss/danger/api")
@Validated
public class XSSTestController {
    private final Tika tika = new Tika();

    @CrossOrigin("*")
    @GetMapping(value = "/greet/{name}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<?> greet(
            @PathVariable @Valid @Pattern(regexp = "[A-Za-z]{5,20}", message = "Name should be between 5-20 character") String name
    ) {
        var result = "Hello, " + name;
        return ResponseEntity.ok(Encode.forHtml(result));
    }

    @CrossOrigin("*")
    @GetMapping("/file")
    public ResponseEntity<Resource> getFile() {
        var resource = new ClassPathResource("static/xss.csv");
        String contentType = "";
        try {
            contentType = tika.detect(resource.getInputStream());

            if (!StringUtils.hasText(contentType) | contentType.equalsIgnoreCase(MediaType.TEXT_HTML_VALUE)) {
                contentType = MediaType.TEXT_PLAIN_VALUE;
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return ResponseEntity.ok().contentType(MediaType.valueOf(contentType)).body(resource);
    }
}
