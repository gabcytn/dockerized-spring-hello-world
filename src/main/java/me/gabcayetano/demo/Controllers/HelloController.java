package me.gabcayetano.demo.Controllers;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gabcayetano.demo.DTOs.HelloRequest;
import me.gabcayetano.demo.DTOs.HelloResponse;
import me.gabcayetano.demo.Services.HelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {
  private final HelloService helloService;

  @GetMapping
  public List<HelloResponse> allHello() {
    log.info("Fetching all hello");
    return helloService.fetchAll();
  }

  @PostMapping
  public HelloResponse createHello(@RequestBody HelloRequest helloRequest) {
    log.info("Saving a hello");
    return helloService.save(helloRequest);
  }

  @GetMapping("/{id}")
  public ResponseEntity<HelloResponse> showHello(@PathVariable UUID id) {
    return helloService.find(id);
  }
}
