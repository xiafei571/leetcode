package algo.expert;

public class BinartSearchTree {
	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}

		public BST insert(int value) {
			// Write your code here.
			if (value < this.value) {
				if (this.left == null) {
					this.left = new BST(value);
				} else {
					this.left.insert(value);
				}
			} else {
				if (this.right == null) {
					this.right = new BST(value);
				} else {
					this.right.insert(value);
				}
			}
			// Do not edit the return statement of this method.
			return this;
		}

		public boolean contains(int value) {
			// Write your code here.
			if (value < this.value) {
				if (this.left == null) {
					return false;
				} else {
					return this.left.contains(value);
				}
			} else if (value > this.value) {
				if (this.right == null) {
					return false;
				} else {
					return this.right.contains(value);
				}
			} else {
				return true;
			}
		}

		public BST remove(int value) {
			// Write your code here.
			remove(value, null);
			// Do not edit the return statement of this method.
			return this;
		}

		private void remove(int value, BST parent) {
			if (value < this.value) {
				if (this.left != null)
					this.left.remove(value, this);
			} else if (value > this.value) {
				if (this.right != null)
					this.right.remove(value, this);
			} else {// value == this.value
				if (this.right != null && this.left != null) {
					this.value = this.right.getMinValue();
					this.right.remove(this.value, this);
				} else if (this.right == null && this.left == null) {
					if (parent == null) {
						// single node tree; do nothing
					} else if (this == parent.left) {
						parent.left = null;
					} else if (this == parent.right) {
						parent.right = null;
					}
				} else {
					if (this.left != null) {
						if (parent == null) {
							this.value = this.left.value;
							this.right = this.left.right;
							this.left = this.left.left;
						} else if (parent.left == this) {
							parent.left = this.left;
						} else {
							parent.right = this.left;
						}
					} else if (this.right != null) {
						if (parent == null) {
							this.value = this.right.value;
							this.left = this.right.left;
							this.right = this.right.right;
						} else if (parent.left == this) {
							parent.left = this.right;
						} else {
							parent.right = this.right;
						}
					}
				}
			}
		}

		public int getMinValue() {
			if (this.left == null) {
				return this.value;
			} else {
				return left.getMinValue();
			}
		}
	}
}
