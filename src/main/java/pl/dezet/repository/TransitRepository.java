package pl.dezet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.dezet.model.Transit;

import java.time.LocalDate;
import java.util.List;

public interface TransitRepository extends JpaRepository<Transit, Long> {

    @Query("SELECT r FROM Transit r WHERE r.date between :start_date and :end_date")
    List<Transit> find(@Param("start_date") LocalDate startDate, @Param("end_date") LocalDate endDate);

}
