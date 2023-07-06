package br.com.fiap.gff.domain.exceptions;

public class RecursoNaoExisteException extends RuntimeException {
    public RecursoNaoExisteException() {
    }

    public RecursoNaoExisteException(String message) {
        super(message);
    }
}
