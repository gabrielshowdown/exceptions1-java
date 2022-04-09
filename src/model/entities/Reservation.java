package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	// Membros Estáticos
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// Atributos
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// Construtor
	public Reservation() {
		
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
		
	// Métodos Acessores
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
	
	// Métodos Acessores
	public long duration() {
		long diff = this.getCheckOut().getTime() - this.getCheckIn().getTime(); // Pega a diferença em milisegundos 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converte o 'diff' que estava em milisegundos para dias
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString(){
		return "Room "
				+ this.getRoomNumber()
				+ ", Check-in: "
				+ sdf.format(this.getCheckIn())
				+ ", Check-out: "
				+ sdf.format(this.getCheckOut())
				+ ", "
				+ duration()
				+ " nights";
	}
}
