package cn.rdlts.webapp.exception;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	protected static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")  
    @ExceptionHandler(IOException.class)  
    @ResponseBody  
    public void handleIOException(){  
        //returning 404 error code  
		logger.error("发生IO错误，返回404。");
    } 
}
