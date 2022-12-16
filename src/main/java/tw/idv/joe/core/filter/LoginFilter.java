/**
 * 
 */
package tw.idv.joe.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import tw.idv.joe.web.entity.Member;

/**
 * 
 * @ClassName: LoginFilter
 * @author:Joe
 * @date 2022年12月13日 上午11:48:05
 *
 */
//@Component
//@WebFilter(urlPatterns = { "member/manage", "member/edit" })
//@Order(value = 1)
//public class LoginFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		
//		HttpSession session = req.getSession();
//		
//		Member member = (Member) session.getAttribute("member");
//	}
//
//}
