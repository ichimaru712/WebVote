package servlet;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserBean userbean =  (UserBean)session.getAttribute("loginUser");
		PasswordBean passwordbean = (PasswordBean)session.getAttribute("userpass");
		UserDAO userdao = new UserDAO();
		PasswordDAO passworddao = new PasswordDAO();

		userdao.userInsert(userbean);
		passworddao.passwordInsert(passwordbean);
		session.removeAttribute("userpass");

		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		HttpSession session = request.getSession();

		String userID = request.getParameter("userid");
		String pass = request.getParameter("password1");
		String userName = request.getParameter("username");
		String sex = request.getParameter("sex");
		Date birthday = Date.valueOf(request.getParameter("birthday"));

		UserBean userBean = new UserBean(userID,userName,null,null,sex,birthday);
		UserBean check = new UserBean();
		UserDAO userDAO = new UserDAO();
		PasswordBean passwordbean = new PasswordBean(userID,pass);
		System.out.println(userBean.getUserName());
		check = userDAO.getUser(userID);
		System.out.println(check.getUserName());
		if(check == null){
			session.setAttribute("usercheck", -1);
			request.getRequestDispatcher("newuser.jsp").forward(request, response);
		}else{
			session.setAttribute("loginUser", userBean);
			session.setAttribute("userpass", passwordbean);
			request.getRequestDispatcher("newusercheck.jsp").forward(request, response);
		}


	}

}
