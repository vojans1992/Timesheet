package timesheet.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import timesheet.model.Timesheet;
import timesheet.service.TimesheetService;
import timesheet.support.TimesheetToTimesheetDto;
import timesheet.web.dto.TimesheetDto;
@CrossOrigin
@RestController
@RequestMapping("api/timesheet")
public class ApiTimesheetController {

	@Autowired TimesheetService timesheetService;
	@Autowired TimesheetToTimesheetDto toDto;
	
	@CrossOrigin
	@GetMapping("/{date}")
	public ResponseEntity<List<TimesheetDto>> get(@PathVariable String date){
		System.out.println("************************************************************************************* " + date);
		List<Timesheet> list = timesheetService.all(date);
		return new ResponseEntity<>(toDto.convert(list), HttpStatus.OK);
	}
	@CrossOrigin
	@PostMapping(consumes = "application/json")
	public ResponseEntity<TimesheetDto> add(@Validated @RequestBody TimesheetDto dto){
		Timesheet saved = timesheetService.save(dto);
		
		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.OK);
	}
}
