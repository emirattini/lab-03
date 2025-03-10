package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ball extends ActiveComponent {

    private Semaphore ballHit, ballArrived;

    public Ball(Semaphore ballHit, Semaphore ballArrived) {
        this.ballHit = ballHit;
        this.ballArrived = ballArrived;
    }

    public void run() {
        while (true) {
            try {
                ballHit.acquire();
                println("ball bouncing");
                ballArrived.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
