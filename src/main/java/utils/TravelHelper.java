package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import model.BookingDateRange;
import model.ComparableBookingDate;

public final class TravelHelper {
	
	/**
	 * check if 2 booking date is overlapped or not.
	 * @param bookDate
	 * @param otherBookDate
	 * @return true if 2 date is overlapped. Otherwise return false
	 */
	public static boolean isOverlappedDate(BookingDateRange bookDate, BookingDateRange otherBookDate) {
		Date startDateA = bookDate.getFromDate();
		Date endDateA = bookDate.getToDate();
		Date startDateB = otherBookDate.getFromDate();
		Date endDateB = otherBookDate.getToDate();
		boolean isStartABeforeEndB = (startDateA.compareTo(startDateB)) < 0;
		boolean isEndAAfterStartB = (endDateA.compareTo(endDateB)) > 0;
		return isStartABeforeEndB && isEndAAfterStartB;
	}
	
	
	/**
	 * @param dateRangeList
	 * @return isExistedOverlapDates is true if there is any overlapped date. Otherwire return false
	 */
	public static boolean isExistedOverlapDates(List<BookingDateRange> dateRangeList) {
		List<ComparableBookingDate> list = new ArrayList<ComparableBookingDate>();
		boolean isExistedOverlapDates = false;
	    for (int i = 0; i < dateRangeList.size(); i++) {
	        Date from = dateRangeList.get(i).getFromDate();
	        Date to = dateRangeList.get(i).getToDate();
	        list.add(new ComparableBookingDate(from, true, i));
	        list.add(new ComparableBookingDate(to, false, i));
	    }
	    
	    // Sort in order of start date
	    Collections.sort(list);
	    
	    HashSet<Integer> active = new HashSet<Integer>();
	    for (ComparableBookingDate item : list) {
	        if (!item.isStartDate()) {
	            active.remove(item.getId());
	        } else {
	            for (Integer itemId : active) {
	            	isExistedOverlapDates = true;
	            	break;
	            }
	            active.add(item.getId());
	        }
	    }
	    
	    return isExistedOverlapDates;
	}

}
