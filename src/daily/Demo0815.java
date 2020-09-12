package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
/**
 * 	找到数组中重复的数字，并返回\
 * 	打印100 - 999中所有的水仙花数
 * @author user
 *
 */
public class Demo0815 {
	//下载 vscode 装插件 ESLint， Vetur， vscode-icons 
	//nodejs node -v v12.18.3

	public static void main(String[] args) {
//		int[] input1 = { 1, 1, 2, 3, 5, 8, 5 };
//		printArray(isRepeat(input1));
//		int[] input2 = { 0, 1, 2, 3, 4 };
//		printArray(isRepeat(input2));
//
//		printNarcissisticNumber();
		tagUser();
	}

	private static void printArray(int[] arrays) {
		for (int i : arrays) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static int[] isRepeat(int[] arrays) {
		// 找到数组中重复的数字，并返回
		// 例如传入 [1,1,2,3,5,8,5] 返回 [1,5]
		// 传入[0,1,2,3,4] 返回 null或者空数组
		List<Integer> repeats = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i : arrays) {
			if (set.contains(i)) {
				repeats.add(i);
			} else {
				set.add(i);
			}
		}

		int[] result = toArray(repeats);
//		return repeats.toArray(new Integer[repeats.size()]);
		return result;
	}

	private static int[] toArray(List<Integer> repeats) {
		int[] result = new int[repeats.size()];
		for (int i = 0; i < repeats.size(); i++) {
			result[i] = repeats.get(i);
		}
		return result;
	}

	private static void printNarcissisticNumber() {
		// 打印100 - 999中所有的水仙花数
		// 水仙花数：一个三位数，其各个位上的数字的立方之和等于这个数本身
		// 153 = 1 + 125 + 27 这就是一个水仙花数
		for (int num = 100; num <= 999; num++) {
			int i = num % 10;
			int j = (num / 10) % 10;
			int k = num / 100;
			// i*i*i
			if (num == Math.pow(i, 3) + Math.pow(j, 3) + Math.pow(k, 3)) {
				System.out.println(num);
			}
		}

	}

	private static void tagUser() {
		// 初始化books
		Map<String, List<String>> books = new HashMap<String, List<String>>();
		books.put("呼吸", Lists.newArrayList("科幻", "美国文学"));
		books.put("时间的秩序", Lists.newArrayList("哲学", "物理", "社会学", "科学"));
		books.put("归训与惩罚", Lists.newArrayList("社会学", "哲学", "历史"));
		books.put("时间与他者", Lists.newArrayList("哲学"));
		books.put("杀死一只知更鸟", Lists.newArrayList("成长", "教育", "美国文学"));
		books.put("坏血", Lists.newArrayList("商业", "纪实", "美国文学", "科技"));
		books.put("枪炮、病菌与钢铁", Lists.newArrayList("人类学", "历史", "社会学"));
		// 初始化users
		Map<String, List<String>> users = new HashMap<String, List<String>>();
		users.put("Tom", Lists.newArrayList("呼吸", "杀死一只知更鸟"));
		users.put("Jerry", Lists.newArrayList("坏血", "呼吸", "时间与他者", "时间的秩序"));
		users.put("rick", Lists.newArrayList("枪炮、病菌与钢铁", "归训与惩罚", "时间的秩序"));
		users.put("morty", Lists.newArrayList("杀死一只知更鸟"));
		
		//输出结果示例 Tom:["美国文学"], Jerry:["美国文学", "哲学"]
		Map<String, List<String>> result = new HashMap<String, List<String>>();

		for (String userName : users.keySet()) {
			List<String> userBookList = users.get(userName);
			Map<String, Integer> bookTagCount = new HashMap<String, Integer>();
			int max = 1;
			for (String bookName : userBookList) {
				List<String> bookTags = books.get(bookName);
				for (String tag : bookTags) {
					if (bookTagCount.containsKey(tag)) {
						int newCount = bookTagCount.get(tag) + 1;
						if(newCount > max) {
							max = newCount;
						}
						bookTagCount.put(tag, newCount);
					} else {
						bookTagCount.put(tag, 1);
					}
				}
			}
			
			List<String> userTags = new ArrayList<String>();
			for(String tag : bookTagCount.keySet()) {
				if(bookTagCount.get(tag) == max) {
					userTags.add(tag);
				}
			}
			result.put(userName, userTags);
		}

		// 遍历map<key, value>
		for (String key : result.keySet()) {
			List<String> tags = result.get(key);
			// 引了guava之后
			System.out.println(key + " : " + Joiner.on("/").join(tags));
		}
	}
}
