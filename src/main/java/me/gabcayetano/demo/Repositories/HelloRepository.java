package me.gabcayetano.demo.Repositories;

import java.util.UUID;
import me.gabcayetano.demo.Entities.Hello;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends ListCrudRepository<Hello, UUID> {}
