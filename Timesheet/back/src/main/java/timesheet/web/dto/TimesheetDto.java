package timesheet.web.dto;

import javax.validation.constraints.NotNull;

public class TimesheetDto {

	private Long id;
	
	@NotNull
	private String title;
	@NotNull
	private int hours;
	private String date;
	public TimesheetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TimesheetDto(Long id, @NotNull String title, @NotNull int hours, String date) {
		super();
		this.id = id;
		this.title = title;
		this.hours = hours;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
}
