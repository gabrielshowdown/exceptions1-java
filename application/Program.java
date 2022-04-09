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
		
		// Importar as informa��es da reserva
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-in Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		// Verificar se a data de checkOut � anterior a data de reserva
		if (!checkOut.after(checkIn)) { // Se a data do checkOut n�o � depois da data do CheckIn, se acontecer, elas sao invalidas
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
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) { // Se a data de check in/out for anterior a agora, nao pode aceitar
				System.out.println("Error in reservation: Reservation dates for update must be future");
			}
			else if (!checkOut.after(checkIn)) { // Se a data de checkOut nao for posterior a data de checkIn, nao pode aceitar
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println();
				System.out.println("Reservation: " + reservation);
			}			
			
		}
		sc.close();
		
	}

}
