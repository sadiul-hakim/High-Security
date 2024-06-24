package org.learn.security_course.dos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dos/v1")
public class RGBController {
    @GetMapping(value = "/green", produces = MediaType.TEXT_PLAIN_VALUE)
    public String green() {
        log.info("green");
        return "green";
    }

    @GetMapping(value = "/blue", produces = MediaType.TEXT_PLAIN_VALUE)
    public String blue() {
        log.info("blue");
        return "blue";
    }

    @GetMapping(value = "/red", produces = MediaType.TEXT_PLAIN_VALUE)
    public String red() {
        log.info("red");

        for(int i=Integer.MIN_VALUE;i<Integer.MAX_VALUE;i++){

        }

        return "red";
    }
}
