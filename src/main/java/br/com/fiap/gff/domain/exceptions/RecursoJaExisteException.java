package br.com.fiap.gff.domain.exceptions;

public class RecursoJaExisteException extends RuntimeException {
    public RecursoJaExisteException(String message) {
        super(message);
    }
}
