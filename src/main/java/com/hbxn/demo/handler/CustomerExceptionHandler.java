package com.hbxn.demo.handler;

import com.hbxn.demo.exception.CustomerException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author SQiang
 * @create 2018-05-18 9:09
 **/
public class CustomerExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
		//打印错误堆信息
		System.out.println(e);

		//定义自定义异常对象句柄
		CustomerException customerException;

		//定义视图名称
		String viewName = httpServletRequest.getParameter("url");

		if(e instanceof  CustomerException){
			customerException = (CustomerException) e;
		}else{
			viewName = "redirect:/error/error.jsp";
			//如果不是业务异常就构建一个系统错误异常
			customerException = new CustomerException("系统出现错误");
		}
		//把异常信息展示到错误页面
		ModelAndView mv = new ModelAndView();
		mv.setViewName(viewName);
		mv.addObject("message",customerException.getMessage());
		return mv;
	}
}
