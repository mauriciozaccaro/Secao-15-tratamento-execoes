package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation_Boa;
import model.exceptions.DomainException;

public class Solucao_Boa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-In Date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservation_Boa reservation = new Reservation_Boa(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation );
			System.out.println();
			
			System.out.println("<<Enter data to update the reservation>>");
			System.out.print("Check-In Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation );
		}
		catch(ParseException e) {
			System.out.println("Invalid Date format!");
		}
		catch(DomainException e) {
			System.out.println("Error in Reservation: " + e.getMessage());
		}
		
		sc.close();
	}

}
