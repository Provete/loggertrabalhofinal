package org.example.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry
{
    private String operacao;
    private String nomeUsuario;
    private String data;
    private String hora;
    private String nomeUsuarioAutenticado;

    public static DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss");

    public LogEntry(Operacao operacao, String nomeUsuario, LocalDateTime dataEHora, String nomeUsuarioAutenticado)
    {
        this.operacao = operacao.getNomeFormatado();
        this.nomeUsuario = nomeUsuario;
        this.data = dataEHora.format(LogEntry.formatadorData);
        this.hora = dataEHora.format(LogEntry.formatadorHora);
        this.nomeUsuarioAutenticado = nomeUsuarioAutenticado;
    }

    public LogEntry(){}

    public String getOperacao()
    {
        return operacao;
    }

    public void setOperacao(String operacao)
    {
        this.operacao = operacao;
    }

    public String getNomeUsuario()
    {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario)
    {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuarioAutenticado()
    {
        return nomeUsuarioAutenticado;
    }

    public void setNomeUsuarioAutenticado(String nomeUsuarioAutenticado)
    {
        this.nomeUsuarioAutenticado = nomeUsuarioAutenticado;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }
}
