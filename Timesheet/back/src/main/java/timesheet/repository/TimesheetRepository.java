package timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import timesheet.model.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

	@Query("SELECT t FROM Timesheet t WHERE" +
			"(:date = NULL OR t.date LIKE :date)")
	List<Timesheet> search(@Param("date") String date);
}
