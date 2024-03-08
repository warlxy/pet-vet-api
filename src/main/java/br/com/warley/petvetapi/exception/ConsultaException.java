package br.com.warley.petvetapi.exception;

public class ConsultaException extends RuntimeException {

    public ConsultaException(Long id) {
        super("Consulta não encontrada com o ID: " + id);
    }

}