package uk.task.waracle.CakeManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.task.waracle.CakeManagement.Model.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake,Long>{
	
	

}
