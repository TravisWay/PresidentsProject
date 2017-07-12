package Presidents;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresidentServlet extends HttpServlet {
	int tN;
	private PresidentDao dao;

	@Override
	public void init() throws ServletException {
		dao = new PresidentFilterDao(this.getServletContext());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Start test for input conditions
		if (req.getParameter("termNumber") == null || req.getParameter("termNumber") == "")  {
			// default to first president for display
			tN = 1;
<<<<<<< HEAD
			req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(), "name", "john").get(0));
=======
			req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(),"name","john").get(0));
>>>>>>> 636c4c119eebc99822ef6e2a685d9e0704e87d62
		} else {
			// text to see if either button was pressed
			if (req.getParameter("nextP") == null) {
				if (req.getParameter("prevP") == null) {
					// if no button was pressed
					tN = Integer.parseInt(req.getParameter("termNumber"));
<<<<<<< HEAD
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(), "name", "john").get(tN - 1));
=======
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(),"name","john").get(tN - 1));
>>>>>>> 636c4c119eebc99822ef6e2a685d9e0704e87d62
					// get the current president
				} else { // previous button was pressed
					if (tN <= 1) {
						// if at the beginning of the list go to the end
<<<<<<< HEAD
						req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(), "name", "john").get(44));
						tN = 45;
					} else {
						// just go to previous president
						req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(), "name", "john").get(tN - 2));
=======
						req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(),"name","john").get(44));
						tN = 45;
					} else {
						// just go to previous president
						req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(),"name","john").get(tN - 2));
>>>>>>> 636c4c119eebc99822ef6e2a685d9e0704e87d62
						tN = tN - 1;
					}
				}
			} else { // next button was pressed
				if (tN >= 45) {
					// if at the end, wrap to beginning
<<<<<<< HEAD
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(), "name", "john").get(0));
					tN = 1;
				} else {
					// just go to the next president
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(), "name", "john").get(tN));
=======
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(),"name","john").get(0));
					tN = 1;
				} else {
					// just go to the next president
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext(),"name","john").get(tN));
>>>>>>> 636c4c119eebc99822ef6e2a685d9e0704e87d62
					tN = tN + 1;
				}
			}
		}
		// go!
		this.getServletContext().getRequestDispatcher("/prezdisplay.jsp").forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
