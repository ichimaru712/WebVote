package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ContentsDAO;
import dao.ContentsdataDAO;
import model.ContentsBean;
import model.ContentsdataBean;

/**
 * Servlet implementation class UpdateContentsdata
 */
@WebServlet("/UpdateContentsdata")
public class UpdateContentsdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContentsdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String contentsid = request.getParameter("c_id");
		String contentsdataid = request.getParameter("d_id");
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();
		ContentsdataBean updatecontentsdata = new ContentsdataBean();
		
		updatecontentsdata = contentsdatadao.getContentsdate(contentsid, contentsdataid);
		
		session.setAttribute("updatecontentsdata", updatecontentsdata);
		
		request.getRequestDispatcher("GetAllContentsdata").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();
		ContentsdataBean contentsdatabean = (ContentsdataBean)session.getAttribute("updatecontentsdata");
		
		String name = request.getParameter("name");
		String intro = request.getParameter("intro");
		String sex = request.getParameter("sex");
		Date birth = Date.valueOf(request.getParameter("birth"));
		
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
		}
		contentsdatadao.contentsdataUpdate(contentsdatabean.getContentsID(), contentsdatabean.getContentsdataID(), name, is, intro, sex, birth);
		
		request.getRequestDispatcher("GetContentsData").forward(request, response);
	}

}
