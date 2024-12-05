package com.dataClip_bo.clipBoard.repository;

import com.dataClip_bo.clipBoard.models.Clip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClipRepository extends MongoRepository<Clip, String> {
}
