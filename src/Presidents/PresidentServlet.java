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
		if (req.getParameter("termNumber") == null) {
			tN = 1;
			req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(0));
		} else {
			
			if (req.getParameter("nextP") == null) {
				if (req.getParameter("prevP") == null) {

					tN = Integer.parseInt(req.getParameter("termNumber"));
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(tN - 1));
					

				} else {
					if (tN <= 1) {

						req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(44));
						tN = 45;
					} else {
						req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(tN - 2));
						tN = tN-1;
					}
				}
			} else {
				if (tN >= 45) {
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(0));
					tN = 1;
				} else {
					req.setAttribute("currentPresident", dao.filterPresidents(getServletContext()).get(tN));
					tN = tN +1;
				}
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
