package homework.basic2.homework4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {

	private String name;
	private Chopstick left;
	private Chopstick right;
	private Integer thinkFactor;

	public Philosopher(String name, Chopstick left, Chopstick right, Integer thinkFactor) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
		this.thinkFactor = thinkFactor;
	}

	private void think() throws InterruptedException {
		if (thinkFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(new Random(5).nextInt(thinkFactor * 500));
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println(this.name + " feels hungry");
				right.take();
				System.out.println(this.name + " picks up " + right);
				left.take();
				System.out.println(this.name + " picks up " + left);
				System.out.println(this.name + " is eating");
				System.out.println(this.name + " is thinking");
				think();
				right.drop();
				left.drop();
			}
		} catch (InterruptedException e) {
			System.out.println(this.name + " " + "exiting via interrupt");
		}
	}
}
