/**
 * 
 */
package tw.idv.joe.web.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.joe.core.pojo.Core;
import tw.idv.joe.web.Service.MemberService;
import tw.idv.joe.web.entity.Member;

/**
 * 
 * @ClassName: EditController
 * @author:Joe
 * @date 2022年12月12日 下午3:32:38
 *
 */

@RequestMapping("member/edit")
@RestController
@SessionAttributes({ "member" })
public class EditController {
	@Autowired
	MemberService service;

	@GetMapping
	public Member getInfo(@SessionAttribute Member member) {
		if (member == null) {
			member = new Member();
			member.setMessage("無此會員資訊");
			member.setSuccessful(false);
		}
		
		return member;
	}

	@GetMapping("{password}")
	public Core checkPassword(@PathVariable String password, @SessionAttribute Member member) {
		final Core core = new Core();
		if (member == null) {
			core.setMessage("無此會員資訊");
			core.setSuccessful(false);
		} else {
			final String currentPassword = member.getPassword();
			core.setSuccessful(Objects.equals(password, currentPassword));
			if (!core.isSuccessful()) {
				core.setMessage("舊密碼錯誤");
			}
		}
		return core;

	}

	@PutMapping
	public Member edit(Model model, @RequestBody Member member, @SessionAttribute("member") Member oMember) {
		member.setUsername(oMember.getUsername());
		member = service.edit(member);
		if (member.isSuccessful()) {
			model.addAttribute("member", member);
			member.setMessage("修改成功");
		}
		return member;
	}
}
