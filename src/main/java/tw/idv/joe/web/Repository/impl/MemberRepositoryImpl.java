/**
 * 
 */
package tw.idv.joe.web.Repository.impl;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;

import tw.idv.joe.web.Repository.MemberOperation;
import tw.idv.joe.web.entity.Member;

/**
 * 
 * @ClassName: MemberRepositoryImpl
 * @author:Joe
 * @date 2022年12月8日 上午11:05:52
 *
 */
public class MemberRepositoryImpl implements MemberOperation {
	@PersistenceContext
	private Session session;

	@Override
	public int update(Member member) {
		final StringBuilder sql = new StringBuilder("update Member set ");
		final String password = member.getPassword();
		final byte[] img = member.getImage();
		
		if(password != null && !password.isEmpty())
			sql.append("password = :password,");
		
		if(img != null && img.length != 0)
			sql.append("image = :image,");
		
		sql.append("nickname = :nickname,")
		   .append("pass = :pass,")
		   .append("roleId = :roleId,")
		   .append("updater = :updater,")
		   .append("lastUpdatedDate = NOW() ")
		   .append("where username = :username");
		
		Query query = session.createQuery(sql.toString());
		
		if(password != null && !password.isEmpty())
			query.setParameter("password", password);
		
		if(img != null && img.length != 0)
			query.setParameter("image", img);
		
		return query.setParameter("nickname", member.getNickname())
					.setParameter("pass", member.getPass())
					.setParameter("roleId", member.getRoleId())
					.setParameter("updater", member.getUpdater())
					.setParameter("username", member.getUsername())
					.executeUpdate();
	}

}
