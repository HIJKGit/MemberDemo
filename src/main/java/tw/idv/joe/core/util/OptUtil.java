/**
 * 
 */
package tw.idv.joe.core.util;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * 
 * @ClassName: OptUtil
 * @author:Joe
 * @date 2022年12月15日 下午1:26:17
 *
 */
public class OptUtil {
	public static <T> T getVal(T value, T nullVal) {
		return Optional.ofNullable(value)
					   .orElseGet(() -> {
					   return nullVal;});
	}

}
