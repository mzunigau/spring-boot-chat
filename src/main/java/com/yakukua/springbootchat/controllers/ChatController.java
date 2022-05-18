package com.yakukua.springbootchat.controllers;

import com.yakukua.springbootchat.models.entities.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

//No es tipo RestController por que no es un API
@Controller
public class ChatController {

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibeMensaje(Mensaje mensaje){
        mensaje.setFecha(new Date().getTime());
        mensaje.setTexto("Recibido por el broker" + mensaje.getTexto());
        return mensaje;

    }

}
