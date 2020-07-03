package homework.basic2.homework4;

public class Chopstick {
	private Integer id;
	private boolean taken = false;

	public Chopstick(Integer id) {
		this.id = id;
	}

	public synchronized void take() throws InterruptedException {
		while (taken) {
			wait();
		}
		taken = true;
	}

	public synchronized void drop() {
		taken = false;
		notifyAll();
	}

	@Override
	public String toString() {
		return "chopstick " + id;
	}
}
