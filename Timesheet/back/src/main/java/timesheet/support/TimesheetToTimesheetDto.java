package timesheet.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.tools.javac.util.Convert;

import timesheet.model.Timesheet;
import timesheet.web.dto.TimesheetDto;

@Component
public class TimesheetToTimesheetDto implements Converter<Timesheet, TimesheetDto>{

	@Override
	public TimesheetDto convert(Timesheet source) {
		// TODO Auto-generated method stub
		TimesheetDto dto = new TimesheetDto();
		dto.setId(source.getId());
		dto.setTitle(source.getTitle());
		dto.setHours(source.getHours());
		dto.setDate(source.getDate());
		return dto;
	}

	public List<TimesheetDto> convert(List<Timesheet> list){
		List<TimesheetDto> dtoList = new ArrayList<>();
		for (Timesheet t : list) {
			dtoList.add(convert(t));
		}
		return dtoList;
	}
}
