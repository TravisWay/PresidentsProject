package Presidents;

import java.util.function.BiPredicate;

public class PresidentInfoPredicate implements BiPredicate<President, String>{

	@Override
	public boolean test(President t, String u) {
		
		return p.getInfo().toLowerCase().contains(s.toLowerCase());
	}
	
	

}
