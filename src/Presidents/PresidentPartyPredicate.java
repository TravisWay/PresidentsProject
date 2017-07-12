package Presidents;

import java.util.function.BiPredicate;

public class PresidentPartyPredicate implements BiPredicate<President, String>{

	public boolean test(President p, String s) {
		return p.getParty().toLowerCase().contains(s.toLowerCase());
	}
	
	

}
