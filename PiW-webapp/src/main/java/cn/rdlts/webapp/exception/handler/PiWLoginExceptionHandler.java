package cn.rdlts.webapp.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import cn.rdlts.webapp.constant.ViewConst;
import cn.rdlts.webapp.exception.PiWLoginException;

@ControllerAdvice
public class PiWLoginExceptionHandler {
	
	protected static Logger logger = Logger.getLogger(PiWLoginExceptionHandler.class);
	
	/**
	 * 改方法可以处理所有没有捕获的PiWLoginException异常。
	 * 
	 * @param ex
	 * @param req
	 * @return
	 */
	@ExceptionHandler(PiWLoginException.class)
	@ResponseStatus(value=HttpStatus.OK)
	public ModelAndView handleLoginException(PiWLoginException ex, WebRequest req) {
		logger.warn("处理用户登录异常行为。");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ViewConst.VIEW_LOGIN);
		logger.error("出现用户登录异常，详细信息：", ex);
		req.setAttribute("errorMessage", ex.getMessage(), RequestAttributes.SCOPE_REQUEST);
		logger.warn("登录异常处理结束。");
		return mav;
	}
}
