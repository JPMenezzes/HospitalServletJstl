package com.example.hospital.Dados;

public class ErroDao extends Exception{
    public ErroDao() {
        super("Erro Dao");
    }

    public ErroDao(String message) {
        super("Erro Dao: "+message);
    }

    public ErroDao(Throwable cause) {
        super("Erro Dao: "+cause);
    }
}
