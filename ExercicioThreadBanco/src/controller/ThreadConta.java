package controller;

import java.util.concurrent.Semaphore;

public class ThreadConta implements Runnable {
	private int codigo;
	private double saldo;
	private double quantia;
	private Semaphore s1;
	private Semaphore s2;
	
	public ThreadConta(int codigo, double saldo, double quantia, Semaphore s1, Semaphore s2) {
		this.codigo = codigo;
		this.saldo = saldo;
		this.quantia = quantia;
		this.s1 = s1;
		this.s2 = s2;
		new Thread(this).start();
		;
	}

	@Override
	public void run() {
		int num = (int) (Math.random() * 100) + 1;
		if(num % 2 == 0) 
			saque();
		else 
			deposito();
		
	}

	public void saque() {
		try {
			s1.acquire();
			System.out.println("Codigo #" + codigo + " realizando saque | Saldo: R$" + String.format("%.2f", saldo) + " saque");
			saldo -= quantia;
			System.out.println("Codigo #" + codigo + " saque realizado | Saldo: R$" + String.format("%.2f", saldo));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s1.release();
		}
		
	}
	public void deposito() {
		try {
			s2.acquire();
			System.out.println("Codigo #" + codigo + " realizando deposito | Saldo R$" + String.format("%.2f", saldo) + " deposito");
			saldo += quantia;
			System.out.println("Codigo #" + codigo + " deposito realizado | Saldo R$" + String.format("%.2f", saldo));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s2.release();
		}
		
	}

}
