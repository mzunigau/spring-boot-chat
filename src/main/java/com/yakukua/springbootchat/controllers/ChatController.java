package com.yakukua.springbootchat.controllers;

import com.yakukua.springbootchat.models.entities.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Random;

//No es tipo RestController por que no es un API
@Controller
public class ChatController {

    private final String[] colores ={"red", "green", "blue", "orange", "magenta" ,"purple"};

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibeMensaje(Mensaje mensaje){
        mensaje.setFecha(new Date().getTime());



        if(mensaje.getTipo().equals("NUEVO_USUARIO")){
            mensaje.setColor(colores[new Random().nextInt(colores.length)]);
            mensaje.setTexto("Nuevo Usuario");
        }

        return mensaje;

    }
    //cuando usuario notifica al broker
    @MessageMapping("/escribiendo")
    // broker notifica a los usuarios
    @SendTo("/chat/escribiendo")
    public String escribiendo(String username){
        return username.concat(" esta escribiendo...");
    }

}
