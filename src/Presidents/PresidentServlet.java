package Presidents;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PresidentServlet extends HttpServlet {

	private PresidentDao dao;

	@Override
	public void init() throws ServletException {
		dao = new PresidentFilterDao(this.getServletContext());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tN = 0;

		if (req.getParameter("nextP") == null) {
			if (req.getParameter("prevP") == null) {
				if (req.getParameter("termNumber") == null) { // ||
																// req.getParameter("termNumber").equals(""))
																// {
					tN = 1;
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(0));
				} else {
					tN = Integer.parseInt(req.getParameter("termNumber"));
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(tN - 1));

				}
			} else {
				if (tN <= 1) {

					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(44));

				} else {
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(tN - 2));
				}
			}
		} else {
			if (tN >= 45) {
				req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(0));

			} else {
				req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(tN));
			}
		}

		this.getServletContext().getRequestDispatcher("/prezdisplay.jsp").forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

}
