package sample;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping(value = "/sample_controller", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SampleController {
    @PostMapping(value = "/test/{namespace}", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('user')")
    private Mono<ResponseEntity<String>> test(@RequestBody @Valid SampleRequest roomRequest,
                                              @PathVariable("namespace") String namespace) {
        return Mono.just(ResponseEntity.ok("ok"));
    }
}
