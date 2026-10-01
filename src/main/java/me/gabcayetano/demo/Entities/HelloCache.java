package me.gabcayetano.demo.Entities;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.gabcayetano.demo.DTOs.HelloResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "hello", timeToLive = 86400L)
public class HelloCache {
  @Id private UUID id;

  private String message;

  public HelloResponse toHelloResponse() {
    return new HelloResponse(id, message);
  }
}
