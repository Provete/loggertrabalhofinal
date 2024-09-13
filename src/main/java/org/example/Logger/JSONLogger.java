package org.example.Logger;

import java.io.*;
import java.time.LocalDateTime;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JSONLogger implements Logger
{
    String caminhoArquivo = "logs/logs.json";


    @Override
    public void log(Operacao operacao, String nomeUsuario, LocalDateTime dataEHora, String nomeUsuarioAutenticado)
    {
        LogEntry logEntry = new LogEntry(operacao, nomeUsuario, dataEHora, nomeUsuarioAutenticado);

        String caminhoAbsolutoArquivo = Paths.get(caminhoArquivo).toAbsolutePath().toString();
        File arquivo = new File(caminhoAbsolutoArquivo);

        if(!arquivo.exists())
        {
            try
            {
                arquivo.getParentFile().mkdirs();
                arquivo.createNewFile();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        List<LogEntry> logEntries;
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        try
        {
            logEntries = mapper.readValue(arquivo, new TypeReference<List<LogEntry>>() {});
        } catch (IOException e) { logEntries = new ArrayList<LogEntry>(); e.printStackTrace(); }

        logEntries.add(logEntry);

        try
        {
            writer.writeValue(arquivo, logEntries);
        } catch(Exception e) { e.printStackTrace(); }
    }


}
