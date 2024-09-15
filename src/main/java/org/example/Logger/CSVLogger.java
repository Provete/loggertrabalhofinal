package org.example.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import org.apache.commons.csv.*;

public class CSVLogger implements Logger
{
    private String caminhoArquivo = "logs/logs.csv";

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

        try(BufferedWriter writer = Files.newBufferedWriter(
                arquivo.toPath(),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE))
        {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.newFormat(';'));

            printer.printRecord(
                    logEntry.getOperacao(),
                    logEntry.getNomeUsuario(),
                    logEntry.getData(),
                    logEntry.getHora(),
                    logEntry.getNomeUsuarioAutenticado()
            );

            writer.write('\n');

            printer.flush();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void logErro(String mensagemErro, Operacao operacao, String nomeUsuario, LocalDateTime dataEHora, String nomeUsuarioAutenticado)
    {
        LogEntry logEntry = new LogEntry(mensagemErro, operacao, nomeUsuario, dataEHora, nomeUsuarioAutenticado);

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

        try(BufferedWriter writer = Files.newBufferedWriter(
                arquivo.toPath(),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE))
        {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.newFormat(';'));

            printer.printRecord(
                    logEntry.getMensagemErro(),
                    logEntry.getOperacao(),
                    logEntry.getNomeUsuario(),
                    logEntry.getData(),
                    logEntry.getHora(),
                    logEntry.getNomeUsuarioAutenticado()
            );
            writer.write('\n');
            printer.flush();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
