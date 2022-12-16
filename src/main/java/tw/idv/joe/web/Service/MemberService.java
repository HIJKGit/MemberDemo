/**
 * 
 */
package tw.idv.joe.web.Service;

import java.util.List;

import tw.idv.joe.web.entity.Member;

/**  
* 
* @ClassName: MemberService
* @author:Joe
* @date 2022年12月8日 上午11:27:43
*
*/
public interface MemberService {
	
	Member login(Member member);
	
	Member register(Member member);
	
	Member edit(Member edit);
	
	Member findById(Integer id);
	
	Member update(Member member);
	
	List<Member> findAll();
	
	Member selectForName(String name);
	
	boolean remove(Integer id);
}
