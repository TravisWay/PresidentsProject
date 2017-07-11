package Presidents;

import java.util.List;

public class PresidentFilterDao implements PresidentDao {
	List<President> allpres;
	
	@Override
	public List<President> filterPresidents(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PresidentFilterDao(){
		Reader reader1 = new Reader();
		reader1.Reader(allpres);
		
		
	}
	
	
}
