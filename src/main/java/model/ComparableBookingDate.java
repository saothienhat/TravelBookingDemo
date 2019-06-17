package model;

import java.util.Date;

public class ComparableBookingDate implements Comparable<ComparableBookingDate> {
	private Date date;
	private boolean isStartDate;
	private int id;
	
	public ComparableBookingDate(Date date, boolean isStartDate, int id) {
		this.date = date;
		this.isStartDate = isStartDate;
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isStartDate() {
		return isStartDate;
	}
	public void setStartDate(boolean isStartDate) {
		this.isStartDate = isStartDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int compareTo(ComparableBookingDate other) {
        int dateCompare = date.compareTo(other.date);
        if (dateCompare != 0) {
            return dateCompare;
        } else {
            if (!isStartDate && other.isStartDate()) {
                return -1;
            } else if (isStartDate && !other.isStartDate()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
	

}
