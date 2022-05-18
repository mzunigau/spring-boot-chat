package com.yakukua.springbootchat.models.service;

import com.yakukua.springbootchat.models.entities.Mensaje;

import java.util.List;

public interface IChatService {

    List<Mensaje> obtenerUltimos10Mensajes();

    Mensaje save(Mensaje mensaje);
}
