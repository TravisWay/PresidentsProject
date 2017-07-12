package Presidents;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrezServlet extends HttpServlet {
	PresidentFilterDao dao;
	int prezIndex;

	@Override
	public void init() throws ServletException {
		dao = new PresidentFilterDao(this.getServletContext());
		prezIndex = 0;

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("currentPresident", dao.filteredPres.get(prezIndex));

		String reset = (String) req.getParameter("reset");
		String termNum = (String) req.getParameter("termNumber");
		String nextButton = (String) req.getParameter("nextP");
		String prevButton = (String) req.getParameter("prevP");
		String filterDrop = (String) req.getParameter("filterdrop");
		String inputString = (String) req.getParameter("inputString");
		

		// test for buttons
		if (!(inputString == null || inputString == "")) {
			dao.filteredPres = dao.filterPresidents(getServletContext(), filterDrop, inputString);
			prezIndex = 0;
			//Empty filter list
			if (dao.filteredPres.isEmpty()) {
				req.setAttribute("error", "error");
				dao.filteredPres = dao.allpres;
				req.setAttribute("currentPresident", dao.filteredPres.get(0));
				prezIndex = 0;
			}
			//Filter returns to beginning
			else{
				req.setAttribute("currentPresident", dao.filteredPres.get(0));
				
			}
		//reset button was pressed	
		} else if (!(reset == null || reset == "")) {
			dao.filteredPres = dao.allpres;
			req.setAttribute("currentPresident", dao.filteredPres.get(0));
			prezIndex = 0;

			// previous button pressed
		} else if (!(prevButton == null || prevButton == "")) {
			prezIndex--;
			if (prezIndex < 0) {
				prezIndex = dao.filteredPres.size() - 1;
			}
			req.setAttribute("currentPresident", dao.filteredPres.get(prezIndex));

			// next button pressed
		} else if (!(nextButton == null || nextButton == "")) {
			prezIndex++;
			if (prezIndex > dao.filteredPres.size() - 1) {
				prezIndex = 0;
			}
			req.setAttribute("currentPresident", dao.filteredPres.get(prezIndex));

			//Chose specific term number
		} else if (!(termNum == null || termNum == "")) {
			prezIndex = Integer.parseInt(termNum) - 1;
			if (prezIndex < 0) {
				prezIndex = dao.filteredPres.size() - 1;
			}
			req.setAttribute("currentPresident", dao.filteredPres.get(prezIndex));
			
		}

		this.getServletContext().getRequestDispatcher("/prezdisplay.jsp").forward(req, resp);
	}
}
