package cn.rdlts.webapp.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.rdlts.common.exception.AbstractPiWException;
import cn.rdlts.common.exception.AbstractPiWRuntimeException;
import cn.rdlts.webapp.constant.ViewConst;

@ControllerAdvice
public class PiWGlobalExceptionHandler {
	
	protected static Logger logger = Logger.getLogger(PiWGlobalExceptionHandler.class);
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Web Error occured")
	@ExceptionHandler(value={AbstractPiWException.class, AbstractPiWRuntimeException.class})
	public ModelAndView handleDefaultError(Exception ex) {
		logger.warn("处理全局错误：\n" + ex.getMessage(), ex);
		ModelAndView mav = new ModelAndView();
		mav.addObject("errorMessage", ex.getMessage());
		mav.setViewName(ViewConst.VIEW_ERROR);
		return mav;
	}
	
	/**
	 * 全局IO异常处理。
	 */
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Error occured")  
    @ExceptionHandler(Exception.class)  
    public void handleIOException(Exception e){  
		logger.error("发生未知错误:" + e.getMessage(), e);
    } 
	
	
}
