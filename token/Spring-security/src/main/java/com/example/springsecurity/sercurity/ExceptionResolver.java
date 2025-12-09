//package com.example.token.sercurity;
//
//import com.example.token.domain.ErrorResponse;
//import com.example.token.exception.ApiCustomException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import javax.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class ExceptionResolver {
//
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ApiCustomException.class)
//    public ResponseEntity<?> handleSQLException(HttpServletRequest request, Exception ex, ApiCustomException e){
//        ErrorResponse response = new ErrorResponse (
//                request.getRequestURI(),e.getMessage());
//        return ResponseEntity.ok(response);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request){
//        return ResponseEntity.status(403).body(new ErrorResponse(request.getServletPath(),"ok"));
//    }
//
//}
