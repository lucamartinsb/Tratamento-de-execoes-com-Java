package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Room number: ");
			Integer roomNumber = in.nextInt();

			System.out.print("Check-in date: ");
			Date checkIn = sdf.parse(in.next());

			System.out.print("Check-out date: ");
			Date checkOut = sdf.parse(in.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.print("Enter data to updade the reservation: ");

			System.out.print("Check-in date: (dd/MM/yyy) ");
			checkIn = sdf.parse(in.next());

			System.out.print("Check-out date: (dd/MM/yyy) ");
			checkOut = sdf.parse(in.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format.");
		} 
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getLocalizedMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Error: Invalid input.");
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}
		in.close();
	}
}
