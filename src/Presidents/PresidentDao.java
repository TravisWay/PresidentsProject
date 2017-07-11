package Presidents;
import java.util.List;

import javax.servlet.ServletContext;

public interface PresidentDao {
	List<President> filterPresidents(ServletContext context);
	

	
	
	
}
