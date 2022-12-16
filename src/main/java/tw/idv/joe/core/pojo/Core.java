/**
 * 
 */
package tw.idv.joe.core.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**  
* 
* @ClassName: Core
* @author:Joe
* @date 2022年12月8日 上午10:49:39
*
*/

@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Core implements Serializable{
	private static final long serialVersionUID = 1073434434375585038L;
	private boolean successful;
	private String message;
	
	public Core() {}
	
	/**
	 * @param successful
	 * @param message
	 */
	public Core(boolean successful, String message) {
		this.successful = successful;
		this.message = message;
	}
	
	
}
