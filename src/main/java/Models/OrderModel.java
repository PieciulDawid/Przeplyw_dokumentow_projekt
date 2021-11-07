package Models;

import java.text.DateFormat;
import java.util.Date;

public class OrderModel implements Model{
	private int Id;
	private int ClientId;
	private int EmployeeId;
	private Date StartDate;
	private State State;
	
	public Object[] toTableRow() {
		return new Object[] {Id, ClientId, DateFormat.getDateInstance().format(StartDate), State};
	}
	
	public enum State {
		STARTED ("Rozpoczęto"),
		INPROGRESS ("W trakcie"),
		FINISHED ("Zakończone");
		
		private final String name;
		
		State(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
}
