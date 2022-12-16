/**
 * 
 */
package tw.idv.joe.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

/**  
* 
* @ClassName: LogoutController
* @author:Joe
* @date 2022年12月13日 上午10:40:30
*
*/

@RestController
@RequestMapping("member/logout")
public class LogoutController {
	
	@GetMapping
	public void logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
	}
}
