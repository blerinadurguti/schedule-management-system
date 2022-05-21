package processor;

import java.sql.SQLException;

import repository.CarryRepository;

public class GjuhaProcessor {

	private CarryRepository carryRepository = new CarryRepository();
	
	public String setGjuha() throws SQLException {
		
		String a = carryRepository.getIdGjuha();
		
		if(a.equals("0")) {
			return "alb";
		}else if(a.equals("1")){
			return "en";
		}else {
		return "alb";
		}
	}
	
}
