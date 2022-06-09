package ktng;

import java.util.ArrayList;
import java.util.List;

public class UserResourceLog {
	/*
	 * 给定一些log，格式如下: time, user_id, resource_id
	 * 第一问要求找出每个user最早访问时间和最迟访问时间（忽略resource）
	 * 第二问要求找出每个五分钟的窗口内，被访问最多的resource_id，以及输出访问次数 
	 * 第三问求一个类似于Markov Chain的东西，类似于下面:
	 * __start__: {resource_1: 0.5, resource_2:0,5} resource_1: {resource_2: 0.5,
	 * __end__: 0.5} resource_2: { __end__: 1}
	 * 也就是‍‌‍‌‌‌‍‌‌‍‌‍‍‍‍‍‌‍‌‌基于每个用户的状态转换，求一个总体的当前状态转换到下一个状态的几率
	 */
	
	public static void main(String[] args) {

		List<Event> input = new ArrayList<Event>();
		Event e1 = new Event(58523, "user_1", "resource_1");
		Event e2 = new Event(62314, "user_2", "resource_2");
		Event e3 = new Event(54001, "user_1", "resource_3");
		Event e4 = new Event(200, "user_6", "resource_5");
		Event e5 = new Event(215, "user_6", "resource_4");
		Event e6 = new Event(54060, "user_2", "resource_3");
		Event e7 = new Event(53760, "user_3", "resource_3");
		Event e8 = new Event(58522, "user_22", "resource_1");
		
		Event e9 = new Event(53651, "user_5", "resource_3");
		Event e10 = new Event(2, "user_6", "resource_1");
		Event e11 = new Event(100, "user_6", "resource_6");
		Event e12 = new Event(400, "user_7", "resource_2");
		Event e13 = new Event(100, "user_8", "resource_6");
		Event e14 = new Event(54359, "user_1", "resource_3");
		input.add(e1);
		input.add(e2);
		input.add(e3);
		input.add(e4);
		input.add(e5);
		input.add(e6);
		input.add(e7);
		input.add(e8);
		input.add(e9);
		input.add(e10);
		input.add(e11);
		input.add(e12);
		input.add(e13);
		input.add(e14);
		System.out.println("Q1:");
		question1(input);
		System.out.println("Q2:");
		question2(input);
		
		List<Event> input2 = new ArrayList<Event>();
		Event f1 = new Event(300, "user_1", "resource_3");
		Event f2 = new Event(599, "user_1", "resource_3");
		Event f3 = new Event(900, "user_1", "resource_3");
		Event f4 = new Event(1199, "user_1", "resource_3");
		Event f5 = new Event(1200, "user_1", "resource_3");
		Event f6 = new Event(1201, "user_1", "resource_3");
		Event f7 = new Event(1202, "user_1", "resource_3");
		input2.add(f1);
		input2.add(f2);
		input2.add(f3);
		input2.add(f4);
		input2.add(f5);
		input2.add(f6);
		input2.add(f7);
		System.out.println("Q1:input2");
		question1(input2);
		System.out.println("Q2:input2");
		question2(input2);
	
	}
	
	private static void question1(List<Event> input) {
		// Map <UserId, List<Time>>
		//排序， 返回最大的和最小的
	}
	
	private static void question2(List<Event> input) {
		// 1. sort by time
		// 2. Deque, 如果event.time - dq.peekFirst().time > 300 就poll first
		// 3. update Map<resource_id, num>
	}
	
	static class Event{
		int time;
		String userId;
		String resourceId;
		public Event(int time, String userId, String resourceId) {
			this.time = time;
			this.userId = userId;
			this.resourceId = resourceId;
		}
	}
	
	/*
	 * Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, 
	 * the ID of the user making the access, and the resource ID.
		The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
		Example:
		logs1 = [
		    ["58523", "user_1", "resource_1"],
		    ["62314", "user_2", "resource_2"],
		    ["54001", "user_1", "resource_3"],
		    ["200", "user_6", "resource_5"],
		    ["215", "user_6", "resource_4"],
		    ["54060", "user_2", "resource_3"],
		    ["53760", "user_3", "resource_3"],
		    ["58522", "user_22", "resource_1"],
		    ["53651", "user_5", "resource_3"],
		    ["2", "user_6", "resource_1"],
		    ["100", "user_6", "resource_6"],
		    ["400", "user_7", "resource_2"],
		    ["100", "user_8", "resource_6"],
		    ["54359", "user_1", "resource_3"],
		]
		Expect Output:
		[ { user_1: [ '54001', '58523' ] },
		  { user_2: [ '54060', '62314' ] },
		  { user_6: [ '2', '215' ] },
		  { user_3: [ '53760', '53760' ] },
		  { user_22: [ '58522', '58522' ] },
		  { user_5: [ '53651', '53651' ] },
		  { user_7: [ '400', '400' ] },
		  { user_8: [ '100', '100' ] } ]
		Example 2:
		logs2 = [
		    ["300", "user_1", "resource_3"],
		    ["599", "user_1", "resource_3"],
		    ["900", "user_1", "resource_3"],
		    ["1199", "user_1", "resource_3"],
		    ["1200", "user_1", "resource_3"],
		    ["1201", "user_1", "resource_3"],
		    ["1202", "user_1", "resource_3"]
		]
		Expect Output: [ { user_1: [ '300', '1202' ] } ]

	 */
	/**
	 * Write a function that takes the logs and returns the resource with 
	 * the highest number of accesses in any 5 minute window, 
	 * together with how many accesses it saw.
	 * @param input
	 */
}
