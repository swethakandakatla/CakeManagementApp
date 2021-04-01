package uk.task.waracle.CakeManagement.Model;

import java.util.List;

public class CakeWrapper {

	List<Cake> cake;


    public CakeWrapper(List<Cake> cake) {
        this.cake = cake;
    }

    public List<Cake> getCake() {
        return cake;
    }
}
