package algo.expert;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction {
	static class MinHeap {
		List<Integer> heap = new ArrayList<Integer>();

		public MinHeap(List<Integer> array) {
			heap = buildHeap(array);
		}

		public List<Integer> buildHeap(List<Integer> array) {
			// Write your code here.
			int rootIdx = (array.size() - 1) / 2;
			for (int currentIdx = rootIdx; currentIdx >= 0; currentIdx--) {
				siftDown(currentIdx, array.size() - 1, array);
			}
			return array;
		}

		public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
			// Write your code here.
			int childLeft = currentIdx * 2 + 1;
			int childRight = currentIdx * 2 + 2;
			while (childLeft <= endIdx) {
				int swapIdx = -1;
				if (childRight <= endIdx && heap.get(childRight) < heap.get(childLeft)) {
					swapIdx = childRight;
				} else {
					swapIdx = childLeft;
				}

				if (heap.get(swapIdx) < heap.get(currentIdx)) {
					swap(currentIdx, swapIdx, heap);
					currentIdx = swapIdx;
					childLeft = currentIdx * 2 + 1;
					childRight = currentIdx * 2 + 2;
				} else {
					return;
				}
			}
		}

		public void siftUp(int currentIdx, List<Integer> heap) {
			// Write your code here.
			int parentIdx = (currentIdx - 1) / 2;
			while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
				swap(currentIdx, parentIdx, heap);
				currentIdx = parentIdx;
				parentIdx = (currentIdx - 1) / 2;
			}
		}

		public int peek() {
			// Write your code here.
			return heap.get(0);
		}

		public int pop() {
			return heap.get(heap.size() - 1);
		}

		public int remove() {
			// Write your code here.
			swap(0, heap.size() - 1, heap);
			int valueToRemove = this.pop();
			heap.remove(heap.size() - 1);
			siftDown(0, heap.size() - 1, heap);
			return valueToRemove;
		}

		public void insert(int value) {
			heap.add(value);
			siftUp(heap.size() - 1, heap);
		}

		private void swap(int i, int j, List<Integer> heap) {
			Integer temp = heap.get(j);
			heap.set(j, heap.get(i));
			heap.set(i, temp);
		}
	}
}
