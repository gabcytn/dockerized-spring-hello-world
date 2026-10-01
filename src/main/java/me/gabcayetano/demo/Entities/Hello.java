package me.gabcayetano.demo.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import me.gabcayetano.demo.DTOs.HelloRequest;
import me.gabcayetano.demo.DTOs.HelloResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
public class Hello {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String message;

  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp private LocalDateTime updatedAt;

  public HelloResponse toHelloResponse() {
    return new HelloResponse(id, message);
  }

  public HelloCache toHelloCache() {
    return new HelloCache(id, message);
  }

  public static Hello fromHelloRequest(HelloRequest helloRequest) {
    Hello hello = new Hello();
    hello.setMessage(helloRequest.message());

    return hello;
  }
}
