package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentsDAO;
import dao.PasswordDAO;
import dao.UserDAO;
import model.ContentsBean;
import model.PasswordBean;
import model.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String id = request.getParameter("userid");
		String password = request.getParameter("password");

		PasswordDAO passwordDAO = new PasswordDAO();
		PasswordBean userpass = new PasswordBean();

		userpass = passwordDAO.searchUser(id, password);

		String path = "";
		if(userpass != null){
			UserBean userBean = new UserBean();
			UserDAO userDAO = new UserDAO();

			userBean = userDAO.getUser(id);
			session.setAttribute("loginUser",userBean);

			//開催中コンテストを取得
			ContentsDAO contentsDAO = new ContentsDAO();
			ArrayList<ContentsBean> contents = new ArrayList<ContentsBean>();
			contents = contentsDAO.getAllContents();

			session.setAttribute("contents",contents);

			if(userBean.getAuthority().equals("U")){
				path = "contents.jsp";
			}else{
				path = "manager.jsp";
			}
		}else{
			path = "login.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
