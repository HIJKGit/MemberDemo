/**
 * 
 */
package tw.idv.joe.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.joe.web.Service.MemberService;
import tw.idv.joe.web.entity.Member;

/**
 * 
 * @ClassName: LoginController
 * @author:Joe
 * @date 2022年12月8日 下午2:16:32
 *
 */

@RestController
@RequestMapping("member/login")
public class LoginController {
	@Autowired
	private MemberService service;

	@GetMapping("{username}/{password}")
	public Member login(HttpServletRequest req, @PathVariable String username, @PathVariable String password) {
		Member member = new Member();
		if (username == null || password == null) {
			member.setMessage("無此會員資訊");
			member.setSuccessful(false);
			return member;
		}

		member.setUsername(username);
		member.setPassword(password);
		member = service.login(member);

		if (member.isSuccessful()) {
			if (req.getSession(false) != null) {
				req.changeSessionId();
			}
			final HttpSession session = req.getSession();
			session.setAttribute("loggedin", true);
			session.setAttribute("member", member);
		}
		return member;
	}
}
