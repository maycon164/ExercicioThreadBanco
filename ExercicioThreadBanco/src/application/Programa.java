package application;

import java.util.concurrent.Semaphore;

import controller.ThreadConta;

public class Programa {

	public static void main(String[] args) {
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(1);

		/*
		ThreadConta t4 = new ThreadConta(4, 10, 1, s1, s2);
		ThreadConta t1 = new ThreadConta(1, 100, 2, s1, s2);
		ThreadConta t2 = new ThreadConta(2, 100, 2, s1, s2);
		ThreadConta t3 = new ThreadConta(3, 90, 5, s1, s2);
		*/
		for(int x = 1; x < 20; x++) {
			ThreadConta t = new ThreadConta(x, 100, x * 2, s1, s2);
		}
	}
}
