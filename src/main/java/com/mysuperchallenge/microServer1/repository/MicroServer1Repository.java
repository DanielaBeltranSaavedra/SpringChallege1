package com.mysuperchallenge.microServer1.repository;


import com.mysuperchallenge.dto.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Stream;

public interface MicroServer1Repository extends MongoRepository<Anime,String> {
    @Query(value="{anime_id : ?0}")
    Anime findByanimeid(int animeid);

}