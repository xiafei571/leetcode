package indeed;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Movingaverage {
	/*
	 * Given a stream of input, and a API int getNow() to get the current time
	 * stamp, Finish two methods:
	 * 
	 * 1. void record(int val) to save the record. 2. double getAvg() to calculate
	 * the averaged value of all the records in 5 minutes.
	 * 
	 * Solution: Maintain a sliding window (queue) which stores the elements in 5
	 * minutes. Also maintain the sum of the records in the window.
	 * 
	 * For the record(), add an event into the queue. Remove all expired events from
	 * the queue. For the getAvg(), first remove the expired events from the queue,
	 * and then calculate the average.
	 * 
	 */
	class Event {
		int timestamp;
		int val;

		public Event(int timestamp, int val) {
			this.timestamp = timestamp;
			this.val = val;
		}
	}

	private Queue<Event> queue = new LinkedList<Event>();
	private int sum = 0;

	private int getNow() {
		return (int) (System.currentTimeMillis() / (1000));
	}

	public void record(int val) {
		queue.offer(new Event(getNow(), val));
		sum += val;
		removeExpired();
	}

	private boolean expired(int currentTime, int eventTime) {
		return (currentTime - eventTime) > 5 * 60;
	}

	private void removeExpired() {
		while (!queue.isEmpty() && expired(getNow(), queue.peek().timestamp)) {
			Event event = queue.poll();
			sum -= event.val;
		}
	}

	private double getAvg() {
		removeExpired();
		if (queue.size() == 0) {
			return 0;
		}
		return sum / queue.size();
	}

	/*
	 * Follow up 1: 5分钟内数据太多了了怎么办。
	 * 如果对record和get_average的性能要求特别高不不想出现突刺情况，就是某个请求要等比较久
	 * 可以把removeExpired函数拿出来专门⽤一个线程去跑，每秒调⽤一次
	 */
	class RemoveExpiredThread implements Runnable {

		/*
		 * 1、start()方法:启动一个线程，不能多次启动一个线程。
		 * 
		 * 2、run()方法:在本线程内调用run()方法，可以重复多次调用。
		 * 
		 * 3、用start()方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码。
		 * 
		 * 4、run()方法只是类的一个普通方法而已，如果直接调用Run方法，程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，还是要顺序执行，
		 * 要等待run方法体执行完毕后才可继续执行下面的代码。
		 */
		@Override
		public synchronized void run() {
			removeExpired();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * Follow Up 2: 接着 内存优化版，这里基于基础版本优化: 注意到expire是根据秒来的,那么我们就把每一秒相同的数据合并即可 用一个双向队列
	 */
	Deque<Event> deque = new LinkedList<Event>();
	int lastTimeStamp = 0;
	int cnt = 0;

	public void record2(int val) {
		cnt++;
		sum += val;
		if (lastTimeStamp != 0 && getNow() == lastTimeStamp) {
			Event lastEvent = deque.peekLast();
			lastEvent.val += val;
		} else {
			lastTimeStamp = getNow();
			deque.offer(new Event(getNow(), val));
		}
		removeExpired();
	}
	/*
	 * Follow Up3: 接下来求中位数，注意求中位数 压缩内存就不不能那么压缩了了,所以都在基础版本上改 两种做法
	 * 1). GetMedian调用的不多用quickselect
	 * 2).调⽤用的多⽤ multiset 或者 2个heap
	 * 3). 如果内存放不不下，求中位数怎么办。 能做到他问这个follow up 说明这个做题速度可以 如果是单机压内存就⽤用树状数组，⼆二分做 如果说单机存不不下就多机，也是树状数组 反正我只想到了了这个思路路
	 */
	
}
