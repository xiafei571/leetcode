package daily;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *     读取文件，计算单词词频
 * @author user
 *
 */
public class Demo0830 {
	/*
	 * 给出一篇短文，找出这篇短文中最具代表性的三个单词
	 * 逻辑：假设已有一个词典，这个词典记录着所有文章中所有单词出现的次数，存储格式为：
	 * K：V
	 * "Hello": 10
	 * "world": 8
	 * "The" : 20
	 * "Tom":5
	 * 意思是hello在所有文章中出现过10次，world出现8次。。。（不区分大小写）
	 * 读取Warren Buffett’s Recent Explanation of How Money Now Works Is the Most Important in History.txt
	 * 获取文章最能代表文章的三个单词(即出现次数最多的三个单词)
	 * 在这篇文章中出现次数比较多，但是在其他文章中出现次数比较少，这样的词才足够有代表性
	 * score
	 * the 66/1000 = 0.066
	 * Buffett’s 10 / 2 = 5
	 * History 20 / 100 =  + 0.2*hot + 0.1*view + 0.1*comments
	 * 
	 * TF/IDF 
	 * 
	 */
	private static List<String> getTags(String filePath, int top_n) throws IOException{
		List<String> lines = readFile(filePath);
		Map<String,Integer> tag_count = new HashMap<String,Integer>();
		
		for(String line : lines) {
			System.out.println(line.replaceAll("[^\\w\\s]", "").toLowerCase());
			String[] words = line.split("\\s");
			if(words.length > 0) {
				for(String word : words) {
					word = word.toLowerCase();
					if(tag_count.containsKey(word)) {
						int count = tag_count.get(word);
						count = count + 1;
						tag_count.put(word, count);
					}else {
						tag_count.put(word, 1);
					}
				}
			}
		}
		
		//排序
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(tag_count.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < list.size() && i < top_n; i++) {
			System.out.println(list.get(i).getKey()+":"+list.get(i).getValue());
			result.add(list.get(i).getKey());
		}
		return result;
	}
	
	private static List<String> readFile(String filePath) throws IOException{
		Path path = Paths.get(filePath);
		List<String> lines = Files.readAllLines(path);
		return lines;
	}
	
	public static void main(String[] args) {
		String path = "src/main/resources/Warren.txt";
		try {
			List<String> tags = getTags(path, 3);
			for(String tag : tags) {
				System.out.println(tag);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
