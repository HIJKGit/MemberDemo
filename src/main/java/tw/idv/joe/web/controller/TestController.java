/**
 * 
 */
package tw.idv.joe.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.joe.web.entity.Member;
import tw.idv.joe.web.Service.MemberService;

/**  
* 
* @ClassName: TestController
* @author:Joe
* @date 2022年12月9日 上午9:16:24
*
*/

@RequestMapping("/test")
@RestController
public class TestController {
	@Autowired
	private MemberService service;

	@PostMapping
	public Member register(@RequestBody Member member) {
		if (member == null) {
			member = new Member();
			member.setMessage("無會員資訊");
			member.setSuccessful(false);
			return member;
		}
		return service.register(member);
	}
}
