package br.com.fiap.gff.infrastructure.adapters.input.rest.handlers;

import br.com.fiap.gff.domain.exceptions.RecursoJaExisteException;
import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.response.MensagemErroResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionsHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<MensagemErroResponse> notFoundError(RecursoNaoEncontradoException ex, HttpServletRequest request) {
        MensagemErroResponse mensagemErro = new MensagemErroResponse(HttpStatus.NO_CONTENT.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemErro);
    }

    @ExceptionHandler(RecursoJaExisteException.class)
    public ResponseEntity<MensagemErroResponse> recursoJaExisteError(RecursoJaExisteException ex, HttpServletRequest request) {
        MensagemErroResponse mensagemErro = new MensagemErroResponse(HttpStatus.NO_CONTENT.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensagemErro);
    }

    @ExceptionHandler(RequisicaoInvalidaException.class)
    public ResponseEntity<MensagemErroResponse> requisicaoInvalidaError(RequisicaoInvalidaException ex, HttpServletRequest request) {
        MensagemErroResponse mensagemErro = new MensagemErroResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemErro);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MensagemErroResponse> notMappedError(RuntimeException ex, HttpServletRequest request) {
        MensagemErroResponse mensageErro = new MensagemErroResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensageErro);
    }

}
