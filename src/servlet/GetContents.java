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

import com.sun.corba.se.spi.orb.StringPair;

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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ひとつのコンテンツを取得し、セッションに格納
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean)session.getAttribute("loginUser");
		
		//コンテンツ取得
		ContentsDAO contentsDAO = new ContentsDAO();
		
		if (userBean.getAuthority().equals("A")) {
			//すべてのコンテンツを取得
			ArrayList<ContentsBean> arraycontents = contentsDAO.getAllContents();
			session.setAttribute("contents", arraycontents);
			
		} else {
			ArrayList<ContentsBean> arraycontents = new ArrayList<ContentsBean>();
			arraycontents = (ArrayList<ContentsBean>)session.getAttribute("contents");
			
			/**int i = 0;
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
			}**/
			int i = Integer.parseInt(request.getParameter("id"));
			ContentsBean contentsBean = contentsDAO.getContents(arraycontents.get(i).getContentsID());
			
			//コンテンツ詳細取得
			ContentsdataDAO contentsdataDAO = new ContentsdataDAO();
			ArrayList<ContentsdataBean> contentsdata = new ArrayList<ContentsdataBean>();
			contentsdata = contentsdataDAO.getAllContentsdata(contentsBean.getContentsID());
			
			session.setAttribute("contentsdata", contentsdata);
			session.setAttribute("contentsBean", contentsBean);
		}
		
		String path = "";
		System.out.println(userBean.getAuthority());
		if(userBean.getAuthority().equals("A")){
			path = "manager.jsp";
		} else {
			path = "contentslist.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
