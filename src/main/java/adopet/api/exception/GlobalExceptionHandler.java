package adopet.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

// A classe anotada com @RestControllerAdvice será chamada sempre que uma exceção for lançada em uma classe controller
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdocaoException.class)
    public ResponseEntity<ResponseError> adocaoException(AdocaoException e) {
        ResponseError response = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Este método irá tratar qualquer exceção que não tenha um tratamento específico (método curinga)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> trataException(Exception e) {
        ResponseError response = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
