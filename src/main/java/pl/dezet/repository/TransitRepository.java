package pl.dezet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.dezet.model.Transit;

import java.util.Date;
import java.util.List;

public interface TransitRepository extends JpaRepository<Transit, Long> {

    @Query("SELECT r FROM Transit r WHERE r.date between :startDate and :endDate")
    List<Transit> find(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
