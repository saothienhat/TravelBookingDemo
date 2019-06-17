package model;

import java.util.Date;

public class BookingDateRange {
	private Date fromDate;
    private Date toDate;
    
    
	public BookingDateRange() {
}
	
	public BookingDateRange(Date fromDate, Date toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}



	public Date getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public Date getToDate() {
		return toDate;
	}
	
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
    
    

}
