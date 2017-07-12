package Presidents;

import java.util.function.BiPredicate;

public class PresidentNamePredicate implements BiPredicate<President, String>{

	@Override
	public boolean test(President p, String s) {
		return p.getName().toLowerCase().contains(s.toLowerCase());
	}

}
