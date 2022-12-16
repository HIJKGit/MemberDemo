/**
 * 
 */
package tw.idv.joe.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**  
* 
* @ClassName: Role
* @author:Joe
* @date 2022年12月8日 上午10:46:04
*
*/
@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	private Integer id;
	private String name;
}
