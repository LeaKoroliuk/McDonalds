package com.valerie;

public class Cashbox {

	private boolean close; 
	private volatile boolean free; 
		
	public Cashbox() {
		this.free = true;
		synchronized (this) {
			notifyAll();
		}
	}
	
	public boolean isClose() {
		return close;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean occupied) {
		this.free = occupied;
	}

	public synchronized void randomClose() {
		int i = (int) (Math.random() * 2 + 1);
		if (i == 1) {
			close = true;
			System.out.println("SORRY, cashbox is closed! All clients go out...");
		}
		if (i == 2) {
			close = false;
			System.out.println("!!! Next, please!");
		}
	}

}