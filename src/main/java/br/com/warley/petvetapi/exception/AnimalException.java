package br.com.warley.petvetapi.exception;

public class AnimalException extends RuntimeException {

    public AnimalException(Long id) {
        super("Animal não encontrado com o ID: " + id);
    }
}