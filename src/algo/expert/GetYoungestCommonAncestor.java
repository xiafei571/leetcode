package algo.expert;

public class GetYoungestCommonAncestor {
	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		// Write your code here.
		int dept_1 = getDescendantDepth(topAncestor, descendantOne);
		int dept_2 = getDescendantDepth(topAncestor, descendantTwo);
		if (dept_1 > dept_2) {
			return backtrackAncestralTree(descendantOne, descendantTwo, dept_1 - dept_2);
		} else {
			return backtrackAncestralTree(descendantTwo, descendantOne, dept_2 - dept_1);
		}
	}

	private static AncestralTree backtrackAncestralTree(AncestralTree lower, AncestralTree higher, int diff) {
		while (diff > 0) {
			lower = lower.ancestor;
			diff--;
		}
		while (lower != higher) {
			lower = lower.ancestor;
			higher = higher.ancestor;
		}
		return lower;
	}

	private static int getDescendantDepth(AncestralTree topAncestor, AncestralTree descendant) {
		int depth = 0;
		while (descendant != topAncestor) {
			depth += 1;
			descendant = descendant.ancestor;
		}
		return depth;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		// This method is for testing only.
		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}
}
