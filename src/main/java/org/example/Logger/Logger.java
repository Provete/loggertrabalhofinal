package org.example.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDateTime;

public interface Logger
{
    void log(Operacao operacao, String nomeUsuario, LocalDateTime dataEHora, String nomeUsuarioAutenticado) throws JsonProcessingException;
}
