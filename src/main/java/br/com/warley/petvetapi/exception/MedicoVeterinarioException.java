package br.com.warley.petvetapi.exception;

public class MedicoVeterinarioException extends RuntimeException {

    public MedicoVeterinarioException(Long id) {
        super("Médico Veterinário não encontrado com o ID: " + id);
    }
}