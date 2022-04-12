package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			// Importar as informacoes da reserva
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
				
			// Instanciar a reserva
			Reservation reservation = new Reservation (number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-in Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation " + reservation); 
		}
		
		catch(ParseException e) {
			System.out.println("Invalide date format");
		}
		
		catch (DomainException e) { // Quando ocorrer a essa excecao, ele sai do try, cai aqui com a mensagem la da classe
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
		
	}

}
