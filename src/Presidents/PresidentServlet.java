package Presidents;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PresidentServlet extends HttpServlet{
	
	private PresidentDao dao;
	@Override
	public void init() throws ServletException {
		dao = new PresidentFilterDao(this.getServletContext());
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		System.out.println(dao.filterPresidents(getServletContext()));
		
		this.getServletContext().getRequestDispatcher("/prezdisplay.jsp").forward(req, resp);
		
	}

	
	
	
}
