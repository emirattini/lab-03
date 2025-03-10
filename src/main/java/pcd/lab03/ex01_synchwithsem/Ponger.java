package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ponger extends ActiveComponent {

	private Semaphore ballArrived, ballHit;

	public Ponger(Semaphore ballArrived, Semaphore ballHit) {
		this.ballArrived = ballArrived;
		this.ballHit = ballHit;
	}
	
	public void run() {
		while (true) {
            try {
                ballArrived.acquire();
				println("pong");
				ballHit.release();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}