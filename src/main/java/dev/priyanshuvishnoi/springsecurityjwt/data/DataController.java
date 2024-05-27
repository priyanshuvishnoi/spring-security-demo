package dev.priyanshuvishnoi.springsecurityjwt.data;

import dev.priyanshuvishnoi.springsecurityjwt.utils.GlobalApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {
    @GetMapping("/helloWorld")
    public ResponseEntity<GlobalApiResponse<Object>> helloWorld() {
        return ResponseEntity.ok(new GlobalApiResponse<>(false, "Hello World!"));
    }
}
