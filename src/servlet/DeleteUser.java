package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PasswordDAO;
import dao.UserDAO;
import model.PasswordBean;
import model.UserBean;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();

		String id = request.getParameter("id");

		UserBean userbean = (UserBean)session.getAttribute("loginUser");
		PasswordBean passwordbean = (PasswordBean)session.getAttribute("loginUser");

		UserDAO userdao = new UserDAO();
		userdao.userDelete(id);
		PasswordDAO passworddao = new PasswordDAO();
		passworddao.passwordDelete(id);

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
