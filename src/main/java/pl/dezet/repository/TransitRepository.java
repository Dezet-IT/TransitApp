package pl.dezet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dezet.model.Transit;

public interface TransitRepository extends JpaRepository<Transit, Long> {
}
