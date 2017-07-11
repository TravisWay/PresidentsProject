package Presidents;

import java.rmi.server.ServerCloneException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentFilterDao implements PresidentDao {
	List<President> allpres;
	
	@Override
	public List<President> filterPresidents(ServletContext context) {
		return allpres;
	}
	
	public PresidentFilterDao(ServletContext servletContext){
		Reader reader1 = new Reader(servletContext);
		allpres = new ArrayList<>();
		this.allpres = reader1.reader(allpres);
		
		
	}
	
	
}
