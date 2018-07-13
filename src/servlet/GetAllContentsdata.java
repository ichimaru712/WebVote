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
import dao.ContentsdataDAO;
import model.ContentsBean;
import model.ContentsdataBean;
import model.UserBean;

/**
 * Servlet implementation class GetContentsdata
 */
@WebServlet("/GetContentsdata")
public class GetAllContentsdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllContentsdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//参加者すべての情報を取得し、セッションに格納
		HttpSession session = request.getSession();
		UserBean userbean = (UserBean)session.getAttribute("loginuser");
		
		String id = "";
		if(request.getParameter("id")==null || request.getParameter("id").equals("")){
			id = (String)request.getAttribute("id");
		}else{
			id = request.getParameter("id");
		}
		
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();
		ArrayList<ContentsdataBean> arraycontentsdata = new ArrayList<ContentsdataBean>();
		arraycontentsdata = contentsdatadao.getAllContentsdata(id);
		session.setAttribute("arraycontentsdata",arraycontentsdata);
		
		if(userbean.getAuthority().equals("A")){
			request.getRequestDispatcher("manager_contentsData.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("*.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
