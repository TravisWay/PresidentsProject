package Presidents;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import javax.servlet.ServletContext;

public class PresidentFilterDao implements PresidentDao {
	List<President> allpres;

	@Override
	public List<President> filterPresidents(ServletContext context, String option, String input) {
		List<President> filteredPres = allpres;
		switch (option) {
		case "Party": case "party":
			filteredPres = filterList(allpres, new PresidentPartyPredicate(), input);
			break;
		case "Name": case "name":
			filteredPres = filterList(allpres, new PresidentNamePredicate(), input);
			break;
		case "Year": case "year":
			filteredPres = filterList(allpres, new PresidentYearPredicate(), input);
			break;
		default:
			filteredPres = filterList(allpres, new PresidentInfoPredicate(), input);
			break;
			
		}
			
		return filteredPres;
	}

	public PresidentFilterDao(ServletContext servletContext) {
		Reader reader1 = new Reader(servletContext);
		allpres = new ArrayList<>();
		this.allpres = reader1.reader(allpres);

	}

	public List<President> filterList(List<President> presidents, BiPredicate<President, String> bipredicate, String s) {
		List<President> tempList = new ArrayList<>();
		for (President president : presidents) {
			if (bipredicate.test(president, s))
				tempList.add(president);
		}
		System.out.println(tempList);
		return tempList;

	}

}
