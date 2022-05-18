package com.yakukua.springbootchat.models.dao;

import com.yakukua.springbootchat.models.entities.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository< Mensaje, String> {

    List<Mensaje> findFirst10ByOrderByFechaDesc();

}
