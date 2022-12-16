/**
 * 
 */
package tw.idv.joe.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tw.idv.joe.core.util.OptUtil;
import tw.idv.joe.web.entity.Member;

import static tw.idv.joe.web.entity.Member.*;
import static java.lang.System.*;

/**
 * 
 * @ClassName: TestApp
 * @author:Joe
 * @date 2022年12月15日 上午11:04:12
 *
 */
public class TestApp {
	public static void main(String[] args) {
		Member member = new Member();
		Member member2 = new Member();
		Member member3 = new Member();
		Integer[] arr = { 74,95,91,20,1, 2, 3, 4, 5, 6, 7, 8,1,2,3,4,5};
		System.out.println(		arr.length);
//		Set set = Arrays.asList(arr).stream().collect(Collectors.toSet());
		Set set = new HashSet<>(Arrays.asList(new String[]{"4","5","4",new String("4")}));
		System.out.println(set.size());
		System.out.println(set.toArray().toString());
		//		Stream<Integer> decimalNumbersOfPI = Stream.generate(() -> 5).limit(100);
//		decimalNumbersOfPI.map(n -> n + 10)
//		                  .filter(n -> n < 15)
//		                  .forEach(n -> out.print(n));
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		
//		List<Integer> biggerThan5 = numbers.stream()
//		                 .filter(number -> number > 5)
//		                 .collect(Collectors.toList())
//		                 .stream()
//		                 .map(n -> n + 10)
//		                 .collect(Collectors.toList());
//		biggerThan5.forEach(out::println);
//		member.setPassword("111111");
//		member2.setPassword("1121112");
//		member3.setPassword("1121112");
//		member.setId(2);
//		member2.setId(3);
//		member3.setId(4);
//		List<Member> lists = new ArrayList<>();
//		lists.add(member2);
//		lists.add(member);
//		lists.forEach(e-> System.out.println(e.getUsername()));
//		Predicate<String> s = str -> str.indexOf("11111") != -1;
//		List<Member> hava11111 = lists.stream().filter(o -> o.getPassword().indexOf("11111") != -1).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//		hava11111.stream().forEach((e) -> out.println(e.getPassword()));
		//		lists.stream()
//		List<Optional<Integer>> high500 = new ArrayList<>();
//		List<Optional<Integer>> low500 = new ArrayList<>();
//		Predicate<Integer> higher = n -> n > 500;
//		Predicate<Integer> lower = n -> n < 500;
//		Predicate<Integer> higt = n -> n < 750;
//		Predicate<Integer> lowgt = n -> n < 750;
//		Set<Integer> set= Arrays.stream(arr).filter(e->e > 3).collect(Collectors.toSet());;
//		out.println(set.contains(4));
//		out.println(set.contains(3));
//		Collections.sort(high500);
//		Optional<Integer> opt = Optional.ofNullable(((int)(Math.random() * 1000)));
//		System.out.println(opt);
//		int i = 0;
//		while(i < 50) {
//			if(!opt.filter(lower).isEmpty())
//			low500.add(opt.filter(lower));
//			if(!opt.filter(higher).isEmpty())
//			high500.add(opt.filter(higher));
//			i++;
//			opt = Optional.of((int)(Math.random() * 1000));
//		}
//		high500.forEach(System.out::println);
//		System.out.println(high500.size());
//		high500.stream().collect(Collectors.toList());
//		System.out.println(low500.size());
//		List<Integer> list = new ArrayList<>();
//		list.addAll(Arrays.asList(arr));
//		Arrays.stream(arr).forEach(out::println);
//		Arrays.sort(arr);
//		System.out.println(list.get(3));
	}
}
