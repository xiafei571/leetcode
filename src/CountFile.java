import java.io.File;

public class CountFile {
	private static int count = 0;

	private static void listFiles(String path) {
		File folder = new File(path);

		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isFile()) {
				if (file.getName().endsWith(".java")) {
					count++;
				}
			} else if (file.isDirectory()) {
				listFiles(file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		listFiles("./");
		System.out.println("Current Java file:" + count);
	}
}
