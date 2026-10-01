package me.gabcayetano.demo.Services;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import me.gabcayetano.demo.DTOs.HelloRequest;
import me.gabcayetano.demo.DTOs.HelloResponse;
import me.gabcayetano.demo.Entities.Hello;
import me.gabcayetano.demo.Repositories.HelloRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HelloService {
  private final HelloRepository helloRepository;

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
}
