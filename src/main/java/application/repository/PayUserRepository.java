package application.repository;

import application.model.PayUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayUserRepository extends JpaRepository<PayUser, String> {
}