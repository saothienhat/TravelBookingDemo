import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BookingDateRange;
import utils.TravelHelper;

public class AppMain {

	public static void main(String[] args) {
		
//		BookingDateRange dateA = new BookingDateRange(new Date("01/01/2018"), new Date("03/01/2018"));
//		BookingDateRange dateB = new BookingDateRange(new Date("02/01/2018"), new Date("08/01/2018"));
//		boolean overlappedDate = TravelHelper.isOverlappedDate(dateA, dateB);
//		System.out.println(overlappedDate);

		/** Overlapped existed from list of BookingDate */
		List<BookingDateRange> overlappedDates = new ArrayList<BookingDateRange>();
		overlappedDates.add(new BookingDateRange(new Date("01/01/2018"), new Date("03/01/2018")));
		overlappedDates.add(new BookingDateRange(new Date("02/01/2018"), new Date("08/01/2018")));
		boolean existedOverlapDates = TravelHelper.isExistedOverlapDates(overlappedDates);
		System.out.println("Is existed Overlap Booking Dates: " + existedOverlapDates);
		
		/** Overlapped NO existed from list of BookingDate */
		List<BookingDateRange> noOverlappedDates = new ArrayList<BookingDateRange>();
		noOverlappedDates.add(new BookingDateRange(new Date("01/01/2018"), new Date("03/01/2018")));
		noOverlappedDates.add(new BookingDateRange(new Date("04/01/2018"), new Date("08/01/2018")));
		noOverlappedDates.add(new BookingDateRange(new Date("01/01/2018"), new Date("08/03/2018")));
		boolean isNoExistedOverlapDates = TravelHelper.isExistedOverlapDates(noOverlappedDates);
		System.out.println("Is existed Overlap Booking Dates: " + isNoExistedOverlapDates);
	}

}
