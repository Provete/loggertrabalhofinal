package org.example.Logger;



public enum Operacao
{
    INCLUSAO ("Inclusão de usuário"),
    ALTERACAO ("Alteração de usuário"),
    EXCLUSAO ("Exclusão de usuário"),

    ENVIO_NOTIFICACAO ("Envio de notificação"),
    LEITURA_NOTIFICACAO ("Leitura de notificação"),
    ALTERACAO_SENHA ("Alteração de senha"),
    AUTORIZACAO_USUARIO("Autorização de usuário");

    private String nomeFormatado;

    Operacao(String nomeFormatado)
    {
        this.nomeFormatado = nomeFormatado;
    }

    public String getNomeFormatado()
    {
        return nomeFormatado;
    }
}
