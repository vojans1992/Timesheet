package timesheet.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import timesheet.model.Timesheet;
import timesheet.service.TimesheetService;
import timesheet.web.dto.TimesheetDto;

@Component
public class TimesheetDtoToTimesheet implements Converter<TimesheetDto, Timesheet>{

	@Autowired TimesheetService timesheetService;
	
	@Override
	public Timesheet convert(TimesheetDto source) {
		// TODO Auto-generated method stub
		Long id = source.getId();
		Timesheet timesheet = id == null ? new Timesheet() : timesheetService.one(id).get();
		if(timesheet != null) {
			timesheet.setId(source.getId());
			timesheet.setTitle(source.getTitle());
			timesheet.setHours(source.getHours());
			timesheet.setDate(source.getDate());
		}
		return timesheet;
	}
	
	public List<Timesheet> convert(List<TimesheetDto> listDto) {
		List<Timesheet> list = new ArrayList<>();
		for(TimesheetDto t : listDto) {
			list.add(convert(t));
		}
		return list;
	}

}
