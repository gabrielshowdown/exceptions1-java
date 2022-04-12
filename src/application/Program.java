package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Importar as informações da reserva
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		// Verificar se a data de checkOut é anterior a data de reserva
		if (!checkOut.after(checkIn)) { // Se a data do checkOut não é depois da data do CheckIn, se acontecer será invalido
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else{
			Reservation reservation = new Reservation (number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
		    System.out.println();
		    if (error!= null) {
		    	System.out.println("Error in reservation " + error);
		    }
		    else{
		    	System.out.println("Reservation: " + reservation);
		    }	
			
		}
		sc.close();
		
	}

}
