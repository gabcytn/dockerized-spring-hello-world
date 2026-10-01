package me.gabcayetano.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gabcayetano.demo.DTOs.HelloRequest;
import me.gabcayetano.demo.DTOs.HelloResponse;
import me.gabcayetano.demo.Entities.Hello;
import me.gabcayetano.demo.Entities.HelloCache;
import me.gabcayetano.demo.Repositories.Cache.HelloCacheRepository;
import me.gabcayetano.demo.Repositories.HelloRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HelloService {
  private final HelloRepository helloRepository;
  private final HelloCacheRepository helloCacheRepository;

  public List<HelloResponse> fetchAll() {
    List<Hello> helloList = helloRepository.findAll();
    List<HelloResponse> responseList = new ArrayList<>();
    helloList.forEach(
        hello -> {
          responseList.add(hello.toHelloResponse());
        });

    return responseList;
  }

  public HelloResponse save(HelloRequest helloRequest) {
    Hello hello = helloRepository.save(Hello.fromHelloRequest(helloRequest));
    return hello.toHelloResponse();
  }

  public ResponseEntity<HelloResponse> find(UUID id) {
    Optional<HelloCache> helloCache = helloCacheRepository.findById(id);
    if (helloCache.isPresent()) {
      log.info("Cache hit");
      return ResponseEntity.ok(helloCache.get().toHelloResponse());
    }

    log.info("Cache miss");

    Optional<Hello> hello = helloRepository.findById(id);
    if (hello.isPresent()) {
      helloCacheRepository.save(hello.get().toHelloCache());
      return ResponseEntity.ok(hello.get().toHelloResponse());
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
