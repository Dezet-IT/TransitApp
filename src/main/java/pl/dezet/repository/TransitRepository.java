package pl.dezet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dezet.model.Transit;

import java.util.Date;
import java.util.List;

public interface TransitRepository extends JpaRepository<Transit, Long> {
    List<Transit> findAllByDateAfter(Date date);
    List<Transit> findAllByDateBefore(Date date);
}
