package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Pinger extends ActiveComponent {

	private Semaphore ballHit, ballArrived;

	public Pinger(Semaphore ballHit, Semaphore ballArrived) {
		this.ballHit = ballHit;
		this.ballArrived = ballArrived;
	}

	public void run() {
		while (true) {
			try {
				ballArrived.acquire();
				println("ping");
				ballHit.release();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}