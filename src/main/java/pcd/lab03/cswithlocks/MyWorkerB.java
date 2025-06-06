package pcd.lab03.cswithlocks;

import java.util.concurrent.locks.Lock;

public class MyWorkerB extends Worker {
	
	private Lock lock;
	
	public MyWorkerB(String name, Lock lock){
		super(name);
		this.lock = lock;
	}

	public void run(){
		while (true){
		  try {
			  // Se avessi usato synchronyzed sui metodi b1/b2 non avrei avuto modo di
			  // sbloccare il lock nel caso in cui i metodi fossero stati usati
			  // Con lockInterruptibly invece tiro eccezione se il lock è occupato
			  lock.lockInterruptibly();
			  b1();
			  b2();
		  } catch (InterruptedException ex) {
		  } finally {
			  lock.unlock();
		  }
		  b3();
		}
	}
	
	protected void b1(){
		println("b1");
		wasteRandomTime(0,1000);	
	}
	
	protected void b2(){
		println("b2");
		wasteRandomTime(100,200);	
	}
	protected void b3(){
		println("b3");
		wasteRandomTime(1000,2000);	
	}
}
