package homework.basic2;

public class MyThread extends Thread {
	private SharedObj o;

	public MyThread(SharedObj o) {
		this.o = o;
	}

	public void run() {
		int n = 0;
		while (n < 10) {
			n++;
			o.inc_ij();
		}
	}

	public static void main(String[] args) {
//		SharedObj o = new SharedObj();
		SharedObj o = new Sync_SharedObj();
		MyThread mt = new MyThread(o);
		mt.start();
		MyThread mt2 = new MyThread(o);
		mt2.start();
	}
}
