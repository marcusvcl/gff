package br.com.fiap.gff.domain.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException() {
    }

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }
}
