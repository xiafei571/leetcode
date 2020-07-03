package homework.basic2.homework4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DiningPhilosopherAvoidDeadlock {
	/*
	 * The reason for this condition is that each Philosopher tries to take the
	 * Chopstick in a specific order: right then left. Because of this, it may
	 * happen that
	 * "everyone is holding the Chopstick on the right and waiting for the Chopstick on the left"
	 * This is the loop waiting condition. However, if the last Philosopher is
	 * initialized to take the Chopstick on the left and then the Chopstick on the
	 * right, then the Philosopher will never stop the Philosopher on the right from
	 * picking up their Chopstick.
	 */
	public static void main(String[] args) throws Exception {
		int think = 0;
		int size = 4;
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		String[] philosophers = { "A", "B", "C", "D" };
		for (int i = 0; i < size; i++)
			sticks[i] = new Chopstick(i + 1);
		for (int i = 0; i < size; i++)
			if (i < (size - 1))
				exec.execute(new Philosopher(philosophers[i], sticks[i], sticks[i + 1], think));
			else
				exec.execute(new Philosopher(philosophers[i], sticks[0], sticks[i], think));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
