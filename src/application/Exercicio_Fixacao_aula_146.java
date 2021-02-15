package application;

import java.util.Scanner;

import model.entities.ContaBancaria;
import model.exceptions.DomainException;

public class Exercicio_Fixacao_aula_146 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("<<ENTER ACCOUNT DATA>>");
		
		System.out.print("NUMBER: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("TITULAR: ");
		String titular = sc.nextLine();
		System.out.print("INITIAL BALANCE: ");
		double balance = sc.nextDouble();
		System.out.print("LIMITE DE SAQUE: ");
		double limiteSaque = sc.nextDouble();
		
		ContaBancaria conta = new ContaBancaria(number, titular, balance, limiteSaque);
		
		System.out.println();
		System.out.println("ENTER AMOUNT FOR WITHDRAW: ");
		double amount = sc.nextDouble();		
		conta.saque(amount);		
		System.out.println(conta.toString());
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		sc.close();

	}

}
