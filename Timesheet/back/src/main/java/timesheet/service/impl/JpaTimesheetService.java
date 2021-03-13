package timesheet.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timesheet.model.Timesheet;
import timesheet.repository.TimesheetRepository;
import timesheet.service.TimesheetService;
import timesheet.support.TimesheetDtoToTimesheet;
import timesheet.web.dto.TimesheetDto;
@Service
public class JpaTimesheetService implements TimesheetService{
	
	@Autowired TimesheetRepository timesheetRepository;
	@Autowired TimesheetDtoToTimesheet toTimesheet;

	@Override
	public List<Timesheet> all(String date) {
		// TODO Auto-generated method stub
		date = "%" + date + "%";
		return timesheetRepository.search(date);
	}

	@Override
	public Optional<Timesheet> one(Long id) {
		// TODO Auto-generated method stub
		return timesheetRepository.findById(id);
	}

	@Override
	public Timesheet save(TimesheetDto timesheetDto) {
		// TODO Auto-generated method stub
		Timesheet timesheet = toTimesheet.convert(timesheetDto);
		Timesheet saved = timesheetRepository.save(timesheet);
		return saved;
	}

	@Override
	public Timesheet update(TimesheetDto timesheetDto) {
		// TODO Auto-generated method stub
		Timesheet timesheet = toTimesheet.convert(timesheetDto);
		Timesheet updated = timesheetRepository.save(timesheet);
		return updated;
	}

	@Override
	public Timesheet delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Timesheet> opt = timesheetRepository.findById(id);
		if(opt.isPresent()) {
			Timesheet timesheet = opt.get();
			timesheetRepository.deleteById(id);
			return timesheet;
		}
		return null;
	}

}
