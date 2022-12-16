/**
 * 
 */
package tw.idv.joe.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.joe.web.Service.MemberService;
import tw.idv.joe.web.entity.Member;

/**  
* 
* @ClassName: SearchControllr
* @author:Joe
* @date 2022年12月13日 上午9:25:29
*
*/

@RestController
@RequestMapping("/member")
public class SearchController {
	@Autowired
	MemberService service;
	
	@GetMapping("/search/{username}")
	public Member search(@PathVariable String username) {
		if(username == null) {
			Member member = new Member();
			member.setMessage("查詢內容為空");
			member.setSuccessful(false);
			return member;
		}
		Member member = service.selectForName(username);
		if(member == null) {
			member = new Member();
			member.setMessage("查無資料");
			member.setSuccessful(false);
			return member;
		}
		
		member.setMessage("查詢成功");
		member.setSuccessful(true);
		return member;
	}
}
