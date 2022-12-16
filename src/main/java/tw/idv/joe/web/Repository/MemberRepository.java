/**
 * 
 */
package tw.idv.joe.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tw.idv.joe.web.entity.Member;

/**  
* 
* @ClassName: MemberRepository
* @author:Joe
* @date 2022年12月8日 上午10:56:05
*
*/
public interface MemberRepository extends JpaRepository<Member, Integer>, MemberOperation{
	Member findByUsername(String username);
	
	Member findByUsernameAndPassword(String username, String password);
	
	@Modifying
	@Query(value = "delete from member where id = :id", nativeQuery = true)
	Integer removeById(Integer id);
}
