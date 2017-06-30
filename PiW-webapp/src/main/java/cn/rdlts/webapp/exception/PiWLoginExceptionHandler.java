package cn.rdlts.webapp.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import cn.rdlts.shiro.ShiroUtils;
import cn.rdlts.webapp.constant.ViewConst;

@ControllerAdvice
public class PiWLoginExceptionHandler {
	
	protected static Logger logger = Logger.getLogger(PiWLoginExceptionHandler.class);
	
	@ExceptionHandler(PiWLoginException.class)
	@ResponseStatus(value=HttpStatus.OK)
	public String handleLoginException(PiWLoginException ex, WebRequest req) {
		logger.warn("处理用户登录异常行为。");
		logger.error("出现用户登录异常，详细信息：", ex);
		req.setAttribute("errorMessage", ex.getMessage(), RequestAttributes.SCOPE_REQUEST);
		logger.warn("登录异常处理结束。");
		return ViewConst.VIEW_LOGIN;
	}
}
