package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner in = new Scanner(System.in);

		System.out.print("Room number: ");
		Integer roomNumber = in.nextInt();

		System.out.print("Check-in date: ");
		Date checkIn = sdf.parse(in.next());

		System.out.print("Check-out date: ");
		Date checkOut = sdf.parse(in.next());

		Reservation reservation = null;

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		} else {
			reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}

		System.out.println();
		System.out.print("Enter data to updade the reservation: ");

		System.out.print("Check-in date: ");
		checkIn = sdf.parse(in.next());

		System.out.print("Check-out date: ");
		checkOut = sdf.parse(in.next());

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Erro in reservation: Reservation dates for update must be future dates.");
		}
		else if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		} else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}

		in.close();
	}
}
