package com.valerie;

public class Client implements Runnable {

	private String name;
	private Cashbox cashbox;
	private boolean isServed;

	public boolean isServed() {
		return isServed;
	}

	public Client(String name, Cashbox cashbox) {
		this.name = name;
		this.cashbox = cashbox;
		new Thread(this).start();
		System.out.println("************** Client# " + name + " entered **************");
	}

	public void run() {

		synchronized (cashbox) {

			while (isServed == false & !cashbox.isClose()) {

				if (!cashbox.isClose() & cashbox.isFree()) {
					cashbox.setFree(false);
					System.out.println("Cashier services Client# " + name + " ...");

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					isServed = true;
					cashbox.setFree(true);

					System.out.println("Client# " + name + " is serviced! And comes out.");

					cashbox.randomClose();
				}

			}

		}

	}

}