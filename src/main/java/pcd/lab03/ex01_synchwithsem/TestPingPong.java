package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {

		Semaphore ballArrived = new Semaphore(0);
		Semaphore ballHit = new Semaphore(0);

		new Pinger(ballArrived, ballHit).start();
		new Ponger(ballArrived, ballHit).start();

		ballHit.release();
	}

}
