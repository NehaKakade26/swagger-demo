package co.reldyn.baas.idv.onfido.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest/api/v1/hello")
public class HelloController {

    @GetMapping
    public HelloMsg hello() {
        log.info("hello - endpoint called");
        return HelloMsg.builder().msg("Hello World!").code(200).build();
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class HelloMsg {
    private String msg;
    private int code;
}
