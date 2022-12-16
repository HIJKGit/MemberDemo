/**
 * 
 */
package tw.idv.joe.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tw.idv.joe.core.pojo.Core;

/**  
* 
* @ClassName: Member
* @author:Joe
* @date 2022年12月8日 上午10:39:01
*
*/
@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends Core implements Serializable{
	private static final long serialVersionUID = -2022895491205599075L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	@Column(insertable = false)
	private Boolean pass;
	@Column(name = "ROLE_ID", insertable = false)
	private Integer roleId;
	@Column(insertable = false, updatable = false)
	private String creator;
	@Column(name = "CREATED_DATE", insertable = false, updatable = false)
	private Timestamp createdDate;
	private String updater;
	@Column(name = "LAST_UPDATED_DATE", columnDefinition = "datetime default now()")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp lastUpdatedDate;
	private byte[] image;
	@ManyToOne
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	private Role role;
}
