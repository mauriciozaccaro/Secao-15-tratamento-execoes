package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation_Boa {
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public Reservation_Boa() {
		
	}

	public Reservation_Boa(Integer roomNumber, Date checkIn, Date checkOut) {

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // capturando a diferen�a entre o
		// tempo de sa�da e entrada em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// convertendo esses milisegundos 
		//em dias.
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("Reservation dates for update must be future dates");
		}
		if(!checkOut.after(checkIn)) {
			throw new IllegalArgumentException("Error in reservation: Data de CheckIn maior que de CheckOut");
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;		
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber
				+ ", check-in "
				+ sdf.format(checkIn)
				+ ", check-Out "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nigths";
	}
	
	
}
