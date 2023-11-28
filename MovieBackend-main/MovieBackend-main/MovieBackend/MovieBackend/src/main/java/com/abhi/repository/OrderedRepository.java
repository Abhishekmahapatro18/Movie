package com.abhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.abhi.model.Ordered;

public interface OrderedRepository extends JpaRepository<Ordered, Long> {
	@Query("SELECT o FROM Ordered o WHERE (o.emailId LIKE %?1%)")
	public List<Ordered> searchByEmail(String emailId);
}
