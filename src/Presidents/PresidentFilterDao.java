package Presidents;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.ServletContext;

public class PresidentFilterDao implements PresidentDao {
	List<President> allpres;
	
	@Override
	public List<President> filterPresidents(ServletContext context) {
		List<President> filteredPres = allpres;
		return filteredPres;
	}
	
	public PresidentFilterDao(ServletContext servletContext){
		Reader reader1 = new Reader(servletContext);
		allpres = new ArrayList<>();
		this.allpres = reader1.reader(allpres);
		
		
	}
	
	public List<President> filteredPres(List<President> presidents, Predicate<President> predicate) {
		return filteredPresident;
				
	}
	
	
}
