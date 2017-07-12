package Presidents;

import java.util.function.BiPredicate;

public class PresidentInfoPredicate implements BiPredicate<President, String> {

	@Override
	public boolean test(President p, String s) {

		return p.getInfo().toLowerCase().contains(s.toLowerCase());
	}

}
