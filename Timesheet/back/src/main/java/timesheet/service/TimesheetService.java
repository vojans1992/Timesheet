package timesheet.service;

import java.util.List;
import java.util.Optional;

import timesheet.model.Timesheet;
import timesheet.web.dto.TimesheetDto;

public interface TimesheetService {

	List<Timesheet> all(String date);;
	Optional<Timesheet> one(Long id);
	Timesheet save(TimesheetDto timesheetDto);
	Timesheet update(TimesheetDto timesheetDto);
	Timesheet delete(Long id);
}
