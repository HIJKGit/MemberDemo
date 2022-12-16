/**
 * 
 */
package tw.idv.joe.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.joe.core.pojo.Core;
import tw.idv.joe.web.Service.MemberService;
import tw.idv.joe.web.entity.Member;

/**  
* 
* @ClassName: ManageController
* @author:Joe
* @date 2022年12月12日 上午11:54:14
*
*/

@Controller
@RequestMapping("member/manage")
public class ManageController {
	@Autowired
	private MemberService service;
	
	@GetMapping
	public String manage(Model model) {
		List<Member> memberList = service.findAll();
		model.addAttribute("memberList",memberList);
		return "WEB-INF/member/manage.jsp";
	}
	
	@DeleteMapping("{id}")
	@ResponseBody
	public Core delete(@PathVariable Integer id) {
		final Core core = new Core();
		System.out.println("test");
		if(id == null) {
			core.setMessage("查無此ID");
			core.setSuccessful(false);
		}else {
			core.setSuccessful(service.remove(id));
			core.setMessage("刪除成功");
		}
		return core;
	}
	
	@PutMapping
	@ResponseBody
	public Core edit(@RequestBody Member member) {
		Core core = new Core();
		if(member == null) {
			core.setMessage("無此會員資訊");
			core.setSuccessful(false);
		}else {
			core.setSuccessful(service.edit(member) != null);
		}
		return core;
	}
}
