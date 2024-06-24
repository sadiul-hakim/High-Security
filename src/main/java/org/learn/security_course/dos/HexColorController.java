package org.learn.security_course.dos;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/hex/v1")
public class HexColorController {
    private static final int COLORS_SIZE = 1_000_000;
    private List<HexColor> hexColors = new ArrayList<>();

    private String randomColorHex() {
        var random = ThreadLocalRandom.current().nextInt(0xffffff + 1);

        return String.format("#%06x", random);
    }

    public HexColorController() {

        for (int i = 1; i <= COLORS_SIZE; i++) {
            hexColors.add(new HexColor(i, randomColorHex()));
        }
    }

    @GetMapping(value = "/random-color", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> randomColor() {
        return ResponseEntity.ok(hexColors);
    }
}
