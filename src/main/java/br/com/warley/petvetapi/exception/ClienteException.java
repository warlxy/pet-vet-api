package br.com.warley.petvetapi.exception;

public class ClienteException extends RuntimeException {

    public ClienteException(Long id) {
        super("Cliente não encontrado com o ID: " + id);
    }
}