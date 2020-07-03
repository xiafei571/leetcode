package demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileDemo {
	public static void main(String args[]) {

		try {
			String filePath = "/Users/xiafei/code/leetcode/src/u-email.txt";
			readFile1(filePath);

			readFile2(filePath);
			
			writeFile("/Users/xiafei/code/leetcode/src/out-test.txt");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void readFile2(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			System.out.println(line);
		}
	}

	private static void readFile1(String filePath) throws IOException {
		FileInputStream fin = new FileInputStream(filePath);
		InputStreamReader reader = new InputStreamReader(fin, "UTF-8");
		BufferedReader buffReader = new BufferedReader(reader);
		String strTmp = "";
		buffReader.readLine();
		while ((strTmp = buffReader.readLine()) != null) {
			String[] str = strTmp.split("\\s");
			System.out.println(str[0] + "," + str[1] + "," + str[2]);
		}
		buffReader.close();
	}

	// 新版本的java提供了NIO，我们可以通过这种新的API达成对文件的读写操作：

	public static void writeFile(String filePath) {
		try {
			File writeName = new File(filePath); // 相对路径，如果没有则要建立一个新的output.txt文件
			writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
			
			FileWriter writer = new FileWriter(writeName);
			BufferedWriter out = new BufferedWriter(writer);
			out.write("我会写入文件啦1\r\n"); // \r\n即为换行
			out.write("我会写入文件啦2\r\n"); // \r\n即为换行
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
