package uk.task.waracle.CakeManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uk.task.waracle.CakeManagement.Model.Cake;
import uk.task.waracle.CakeManagement.Repository.CakeRepository;

@DataJpaTest
public class CakeTests {
	
	@Autowired
	private CakeRepository cakeRepo;
	
	@Test
	public void testCreateCake() {
		Cake cake = new Cake("ButterScotch","WithEgg",55);
		cakeRepo.save(cake);
	}
	
}
