package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.AbstractDocument.Content;

import dao.ContentsDAO;
import dao.ContentsdataDAO;
import model.ContentsBean;
import model.ContentsdataBean;
import model.UserBean;

/**
 * Servlet implementation class GetContents
 */
@WebServlet("/GetContents")
public class GetContents extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetContents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//すべてのコンテンツを取得し、セッションに格納
		HttpSession session = request.getSession();
		UserBean userbean = (UserBean)session.getAttribute("loginuser");
		ContentsDAO contentsdao = new ContentsDAO();
		ArrayList<ContentsBean> arraycontents = new ArrayList<ContentsBean>();
		arraycontents = contentsdao.getAllContents();
		session.setAttribute("arraycontents",arraycontents);
		
		if(userbean.getAuthority().equals("A")){
			request.getRequestDispatcher("U02.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("*.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ひとつのコンテンツを取得し、セッションに格納
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean)session.getAttribute("loginuser");
		
		ArrayList<ContentsBean> arraycontents = new ArrayList<ContentsBean>();
		arraycontents = (ArrayList<ContentsBean>)session.getAttribute("contents");
		int i = 0;
		try {
			//hiddenの値が改変されてないか
			i = Integer.parseInt(request.getParameter("id"));
			
			if (i < arraycontents.size()) {
				//hidden
				throw new Exception();
			}
		} catch (Exception e) {
			//hiddenの値改変
			System.out.println("値が改変されました");
			request.getRequestDispatcher("contents.jsp").forward(request, response);
		}
		//コンテンツ取得
		ContentsDAO contentsDAO = new ContentsDAO();
		ContentsBean contentsBean = contentsDAO.getContents(arraycontents.get(i).getContentsID());
		
		//コンテンツ詳細取得
		ContentsdataDAO contentsdataDAO = new ContentsdataDAO();
		ArrayList<ContentsdataBean> contentsdata = new ArrayList<ContentsdataBean>();
		contentsdata = contentsdataDAO.getAllContentsdata(contentsBean.getContentsID());
		
		session.setAttribute("contentsdata", contentsdata);
		session.setAttribute("contentsBean", contentsBean);
		
		request.getRequestDispatcher("contentslist.jsp").forward(request, response);
	}

}
