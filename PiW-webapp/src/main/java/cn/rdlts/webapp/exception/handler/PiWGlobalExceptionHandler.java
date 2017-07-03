package cn.rdlts.webapp.exception.handler;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.rdlts.common.exception.AbstractPiWException;
import cn.rdlts.common.exception.AbstractPiWRuntimeException;
import cn.rdlts.webapp.constant.ViewConst;

@ControllerAdvice
public class PiWGlobalExceptionHandler {
	
	protected static Logger logger = Logger.getLogger(PiWGlobalExceptionHandler.class);
	
	@ExceptionHandler(value={AbstractPiWException.class, AbstractPiWRuntimeException.class})
	public ModelAndView handleDefaultError(Exception ex) {
		logger.warn("处理全局错误：\n" + ex.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.addObject("errorMessage", ex.getMessage());
		mav.setViewName(ViewConst.VIEW_ERROR);
		return mav;
	}
	
	/**
	 * 全局IO异常处理。
	 */
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")  
    @ExceptionHandler(IOException.class)  
    @ResponseBody  
    public void handleIOException(){  
        //returning 404 error code  
		logger.error("发生IO错误，返回404。");
    } 
}
