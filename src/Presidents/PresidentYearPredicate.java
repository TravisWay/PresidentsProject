package Presidents;

import java.util.function.BiPredicate;

public class PresidentYearPredicate implements BiPredicate<President, String> {

	@Override
	public boolean test(President p, String s) {
		try {
			int year = Integer.parseInt(s);
			if (year >= p.getStartYear() && year <= p.getEndYear()) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			return true;
		}

	}

}
