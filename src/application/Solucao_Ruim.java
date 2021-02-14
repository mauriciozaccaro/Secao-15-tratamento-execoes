package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//import jdk.internal.net.http.ResponseTimerEvent;
import model.entities.Reservation;
import model.entities.Reservation_Ruim;

public class Solucao_Ruim {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-In Date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Data de CheckIn maior que de CheckOut");
		}
		else { 
			Reservation_Ruim reservation = new Reservation_Ruim(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation );
			System.out.println();
			
			System.out.println("<<Enter data to update the reservation>>");
			System.out.print("Check-In Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			String error = reservation.updateDates(checkIn, checkOut);
			
			if(error != null) {
				System.out.println("Error in Reservation: " + error);
			}else {
			System.out.println("Reservation: " + reservation );
			}
			
			//System.out.println("Reservation: " + reservation );
		}
		
		
		sc.close();
	}

}
