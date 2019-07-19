package com.valerie;

public class Main {

	public static void main(String[] args) {

		Cashbox cashbox = new Cashbox();

		for (int i = 1; i <= 5; i++) {
			new Client(Integer.toString(i), cashbox);
		}
	}
}
