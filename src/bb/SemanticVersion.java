package bb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SemanticVersion {

	static class TreeNode {
		Integer val;
		List<TreeNode> childs;

		public TreeNode(Integer val) {
			this.val = val;
			childs = new ArrayList<TreeNode>();
		}
	}

	static class SemanticVersionGenerator {
		TreeNode root;

		public SemanticVersionGenerator(String[] existing) {
			List<String[]> list = new ArrayList<String[]>();
			for (String str : existing) {
				list.add(str.split("\\."));
			}

			Collections.sort(list, new Comparator<String[]>() {
				@Override
				public int compare(String[] s1, String[] s2) {

					for (int i = 0; i < s1.length; i++) {
						Integer i1 = Integer.valueOf(s1[i]);
						Integer i2 = Integer.valueOf(s2[i]);
						if (i1 - i2 > 0) {
							return 1;
						} else if (i1 - i2 < 0) {
							return -1;
						} else {
							continue;
						}
					}
					return 0;
				}

			});
			root = new TreeNode(null);
			//TODO 优化 递归
			for (String[] version : list) {
				Integer major = Integer.valueOf(version[0]);
				Integer minor = Integer.valueOf(version[1]);
				Integer patch = Integer.valueOf(version[2]);

				List<TreeNode> majors = root.childs;
				if (majors.size() == 0) {
					majors.add(new TreeNode(major));
				} else if (majors.get(majors.size() - 1).val != major) {
					majors.add(new TreeNode(major));
				}

				TreeNode majorNode = majors.get(majors.size() - 1);
				List<TreeNode> minors = majorNode.childs;
				if (minors.size() == 0) {
					minors.add(new TreeNode(minor));
				} else if (majors.get(majors.size() - 1).val != minor) {
					minors.add(new TreeNode(minor));
				}

				TreeNode patchNode = minors.get(minors.size() - 1);
				List<TreeNode> patchs = patchNode.childs;
				if (patchs.size() == 0) {
					patchs.add(new TreeNode(patch));
				} else if (patchs.get(patchs.size() - 1).val != patch) {
					patchs.add(new TreeNode(patch));
				}
			}

		}

		public String getNextMajor() {
			String major = String.valueOf(root.childs.get(root.childs.size() - 1).val + 1);
			return major + ".0.0";
		}

		public String getNextMinor(String major) {
			for (TreeNode node : root.childs) {
				if (node.val == Integer.valueOf(major)) {
					List<TreeNode> minors = node.childs;
					String minor = String.valueOf(minors.get(minors.size() - 1).val + 1);
					return major + "." + minor + ".0";
				}
			}
			return null;
		}

		public String getNextPatch(String major, String minor) {
			for (TreeNode node : root.childs) {
				if (node.val == Integer.valueOf(major)) {
					List<TreeNode> minors = node.childs;
					for (TreeNode nodenode : minors) {
						if (nodenode.val == Integer.valueOf(minor)) {
							List<TreeNode> pathcs = nodenode.childs;
							String patch = String.valueOf(pathcs.get(pathcs.size() - 1).val + 1);
							return major + "." + minor + "." + patch;
						}
					}
				}
			}
			return null;
		}
	}

	public static void main(String[] args) {
		SemanticVersionGenerator generator = new SemanticVersionGenerator(new String[] { "1.2.3", "1.1.2", "3.2.1" });
		System.out.println(generator.getNextMajor());
		System.out.println(generator.getNextMinor("1"));
		System.out.println(generator.getNextPatch("3", "2"));

	}

}
