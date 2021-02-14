package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation_Ruim {
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	public Reservation_Ruim() {
		
	}

	public Reservation_Ruim(Integer roomNumber, Date checkIn, Date checkOut) {

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
		long diff = checkOut.getTime() - checkIn.getTime(); // capturando a diferença entre o
		// tempo de saída e entrada em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// convertendo esses milisegundos 
		//em dias.
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if(!checkOut.after(checkIn)) {
			return "Error in reservation: Data de CheckIn maior que de CheckOut";
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null; // se retornar NULO é porque passou na logica acima sem nenhum erro...
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
