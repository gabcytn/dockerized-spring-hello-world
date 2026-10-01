package me.gabcayetano.demo.Repositories.Cache;

import java.util.UUID;

import me.gabcayetano.demo.Entities.HelloCache;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloCacheRepository extends ListCrudRepository<HelloCache, UUID> {}
