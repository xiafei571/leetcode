package am;

import java.util.PriorityQueue;

public class MedianFinder295 {
	/** initialize your data structure here. */
	private int count;
	private PriorityQueue<Integer> maxheap;
	private PriorityQueue<Integer> minheap;

	public MedianFinder295() {
		count = 0;
		maxheap = new PriorityQueue<Integer>((x, y) -> y - x);
		minheap = new PriorityQueue<Integer>((x, y) -> x - y);
	}

	public void addNum(int num) {
		count++;
		maxheap.add(num);
		minheap.add(maxheap.poll());
		if (count % 2 == 1) {//如果是基数，再还回去
			maxheap.add(minheap.poll());
		}
	}

	public double findMedian() {
		if (count % 2 == 0) {
			// 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
			return (double) (maxheap.peek() + minheap.peek()) / 2.0;
		} else {
			// 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
			return (double) maxheap.peek();
		}
	}
}
