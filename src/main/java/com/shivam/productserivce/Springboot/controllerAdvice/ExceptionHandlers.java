package com.shivam.productserivce.Springboot.controllerAdvice;

import com.shivam.productserivce.Springboot.DTOs.ArithmeticExceptionDTO;
import com.shivam.productserivce.Springboot.DTOs.ExceptionDTO;
import com.shivam.productserivce.Springboot.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDTO> handleArithmeticExpression() {
           ArithmeticExceptionDTO arithmeticExceptionDTO= new ArithmeticExceptionDTO();
           arithmeticExceptionDTO.setMessage("SomethingBad has happened");
           return new ResponseEntity<>(arithmeticExceptionDTO,HttpStatus.OK);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Void> handNullPointerException()
    {
         return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler(ProductNotExistsException.class)
   public ResponseEntity<ExceptionDTO> handleProductNotExistExcelption(ProductNotExistsException exception)
   {
       ExceptionDTO exceptionDTO= new ExceptionDTO();
       exceptionDTO.setMessage(exception.getMessage());

       return new ResponseEntity<>(exceptionDTO, HttpStatus.CONTINUE);
   }
}
