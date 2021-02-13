package application.repository;

import application.model.BannedPhonenumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannedNumberRepository extends JpaRepository<BannedPhonenumber, String> {
}