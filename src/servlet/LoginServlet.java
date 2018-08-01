package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

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
import sec.SafePassword;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		PasswordDAO passwordDAO = new PasswordDAO();
		PasswordBean userpass = new PasswordBean();
		SafePassword safepass = new SafePassword();

		String id = request.getParameter("userid");
		String password = request.getParameter("password");
		
		String hashpass = safepass.getStretchedPassword(password, id);

		userpass = passwordDAO.searchUser(id, hashpass);

		String path = "";
		if(userpass != null){
			UserBean userBean = new UserBean();
			UserDAO userDAO = new UserDAO();

			userBean = userDAO.getUser(id);
			session.setAttribute("loginUser",userBean);

			//現在日を取得
			java.util.Date util_date = new java.util.Date();
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(util_date);
			
			Date date = new Date(calendar.getTimeInMillis());
			
			ContentsDAO contentsDAO = new ContentsDAO();
			
			//開催中・開催前
			ArrayList<ContentsBean> activeContents = contentsDAO.getActiveContents(date);
			//開催終了
			ArrayList<ContentsBean> noactiveContents = contentsDAO.getNoActiveContents(date);
			
			if(activeContents.size() == 0){
				session.setAttribute("activeContents", null);
			} else {
				session.setAttribute("activeContents", activeContents);
			}
			
			if (noactiveContents.size() == 0) {
				session.setAttribute("noactiveContents", null);
			} else {
				session.setAttribute("noactiveContents", noactiveContents);
			}
			
			if(userBean.getAuthority().equals("U")){
				path = "contents.jsp";
			}else{
				ArrayList<UserBean> users = userDAO.getAllUser();
				session.setAttribute("users", users);
				path = "manager.jsp";
			}
		}else{
			path = "login.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
