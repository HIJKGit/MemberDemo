/**
 * 
 */
package tw.idv.joe.web.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* 
* @ClassName: ErrorPageController
* @author:Joe
* @date 2022年12月14日 下午4:34:40
*
*/
@Controller
@RequestMapping("/error")
public class ErrorPageController implements ErrorController{
	
	@GetMapping
	public String handleError() {
		// 該資源位於resources/static目錄下
	  	return "error.html"; 
	  }
}
