/**
 * 
 */
package tw.idv.joe.web.Service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.joe.core.util.OptUtil;
import tw.idv.joe.web.Repository.MemberRepository;
import tw.idv.joe.web.Service.MemberService;
import tw.idv.joe.web.entity.Member;

/**
 * 
 * @ClassName: MemberServiceImpl
 * @author:Joe
 * @date 2022年12月8日 上午11:28:30
 *
 */

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository repository;

	@Override
	public Member login(Member member) {
		final String username = member.getUsername().trim();
		final String password = member.getPassword();

		if (username == null || username.isBlank()) {
			member.setMessage("帳號尚未輸入。");
			member.setSuccessful(false);
			return member;
		}

		if (password == null) {
			member.setMessage("密碼尚未輸入。");
			member.setSuccessful(false);
			return member;
		}

		member = repository.findByUsernameAndPassword(username, password);
		if (member == null) {
			member = new Member();
			member.setMessage("帳號或密碼錯誤。");
			member.setSuccessful(false);
			return member;
		}

		member.setMessage("登入成功！");
		member.setSuccessful(true);
		return member;
	}

	@Override
	public Member register(Member member) {
		final String username = member.getUsername();
		final String password = member.getPassword();
		final String nickname = member.getNickname();
		if (username == null || username.isBlank()) {
			member.setMessage("帳號尚未輸入");
			member.setSuccessful(false);
			return member;
		}

		if (password == null) {
			member.setMessage("密碼尚未輸入");
			member.setSuccessful(false);
			return member;
		}

		if (nickname == null || nickname.isBlank()) {
			member.setMessage("暱稱尚未輸入");
			member.setSuccessful(false);
			return member;
		}

		if (repository.findByUsername(username) != null) {
			member.setMessage("帳號重複");
			member.setSuccessful(false);
			return member;
		}
		member = repository.save(member);
		if (member == null) {
			member = new Member();
			member.setMessage("註冊錯誤，請聯絡管理員。");
			member.setSuccessful(false);
			return member;
		} else {
			member.setMessage("註冊成功");
			member.setSuccessful(true);
		}
		return member;
	}
	@Transactional
	@Override
	public Member edit(Member member) {
		final Member oMember = repository.findByUsername(member.getUsername());
		member.setPass(oMember.getPass());
		member.setRoleId(oMember.getRoleId());
		member.setUpdater(member.getUsername());
		final int resultCount = repository.update(member);
		member.setSuccessful(resultCount > 0);
		member.setMessage(resultCount > 0 ? "修改成功" : "修改失敗");
		
		String password = OptUtil.getVal(member.getPassword(), oMember.getPassword()).trim();
		member.setPassword(password);
		if(member.getImage() == null || member.getImage().length == 0) {
			member.setImage(oMember.getImage());
		}
		
		member.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
		return member;
	}

	@Override
	public Member findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Member> findAll() {
		return repository.findAll();
	}

	@Override
	public Member selectForName(String name) {
		return repository.findByUsername(name);
	}

	@Transactional
	@Override
	public boolean remove(Integer id) {
		return repository.removeById(id) > 0;
	}

	@Transactional
	@Override
	public Member update(Member member) {
		final Member oMember = repository.findByUsername(member.getUsername());
		if(member.getImage() == null || member.getImage().length == 0) {
			member.setImage(oMember.getImage());
		}
		member.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));

		return repository.save(member);
	}

}
