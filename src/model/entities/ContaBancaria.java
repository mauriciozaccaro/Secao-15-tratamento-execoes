package model.entities;

import model.exceptions.DomainException;

public class ContaBancaria {

	private Integer number;
	private String titular;
	private Double balance;
	private Double limiteSaque;
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(Integer number, String titular, Double balance, Double limiteSaque) {
		
		this.number = number;
		this.titular = titular;
		this.balance = balance;
		this.limiteSaque = limiteSaque;
		
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void saque(Double amount) throws DomainException {
		if (amount > limiteSaque) {
			throw new DomainException("O Valor solicitado excede o Limite de Saque!");
		}
		if(amount > balance) {
			throw new DomainException("Saldo insuficiente!");
		}
		balance -= amount;
	}
	
	public String toString() {
		return "New Balance: " + String.format("%.2f\n", getBalance());
	}
	
}
