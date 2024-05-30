package in.vp.main.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import in.vp.main.entity.ErrorObject;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleResourcenotFoundException(ResourceNotFoundException ex){
			String massage=ex.getMessage();
		ErrorObject err=new ErrorObject(massage,false);
		
	return new ResponseEntity<ErrorObject>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotVaild(MethodArgumentNotValidException ex){
		Map<String , String> map= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->
		{
		String fieldName=((FieldError)error).getField();
		String massage=error.getDefaultMessage();
		map.put(fieldName, massage);
		}
		);
		return new ResponseEntity<Map<String,String>> (map,HttpStatus.OK);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleMethodArgumentException(MethodArgumentTypeMismatchException ex){
		
		String 	message=ex.getMessage();
		ErrorObject err=new ErrorObject(message,false);
		
		return new ResponseEntity<ErrorObject>(err,HttpStatus.OK);
		
		
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<ErrorObject> handleTransactionSystemException(TransactionSystemException ex){
		
	String	message=ex.getMessage();
	ErrorObject err=new ErrorObject(message,false);
	
	return new ResponseEntity<ErrorObject>(err,HttpStatus.OK);
		
	}

}
