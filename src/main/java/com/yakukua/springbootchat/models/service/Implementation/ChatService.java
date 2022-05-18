package com.yakukua.springbootchat.models.service.Implementation;

import com.yakukua.springbootchat.models.dao.ChatRepository;
import com.yakukua.springbootchat.models.entities.Mensaje;
import com.yakukua.springbootchat.models.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements IChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Mensaje> obtenerUltimos10Mensajes() {
        return chatRepository.findFirst10ByOrderByFechaDesc();
    }

    @Override
    public Mensaje save(Mensaje mensaje) {
        return chatRepository.save(mensaje);
    }
}
