/**
 * 
 */
package tw.idv.joe.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.joe.web.Service.MemberService;
import tw.idv.joe.web.entity.Member;

/**  
* 
* @ClassName: RegisterController
* @author:Joe
* @date 2022年12月9日 上午10:40:45
*
*/

@RequestMapping("member/register")
@RestController
public class RegisterController {
	@Autowired
	MemberService service;
	
	@PostMapping
	Member register(@RequestBody Member member) {
		if(member == null) {
			member = new Member();
			member.setMessage("無此會員資訊");
			member.setSuccessful(false);
			return member;
		}
		return service.register(member);
	}
}
