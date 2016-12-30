package com.example;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@ControllerAdvice
public class ExceptionHandler
{
	@org.springframework.web.bind.annotation.ExceptionHandler(FileNotFoundException.class)
	public @ResponseBody ErrorInfo handleError(HttpServletRequest req, Exception ex)
	{

		ModelAndView mav = new ModelAndView();
		// mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return new ErrorInfo(ex.getMessage());
	}
}
