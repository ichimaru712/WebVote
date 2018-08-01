package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(maxFileSize=1048576)
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
		ContentsdataBean contentsdatabean = (ContentsdataBean)session.getAttribute("contentsdata");
		
		String name = request.getParameter("name");
		String intro = request.getParameter("introduction");
		String sex = request.getParameter("sex");
		String y_birth = request.getParameter("birthday");
		
		Date birth = null;
		try{
			// String → java.util.Date → java.sql.Date
						SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
						
						
						// input type="date"の値から余計な文字列を削除
						y_birth = y_birth.replace("T", " ");
						
						java.util.Date util_birth = new java.util.Date();
						
						// String → java.util.Date
						util_birth = sFormat.parse(y_birth);
						
						// java.util.Date → java.sql.Date
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(util_birth);
						calendar.set(Calendar.HOUR_OF_DAY, 0);
						calendar.set(Calendar.MINUTE, 0);
						calendar.set(Calendar.SECOND, 0);
						calendar.set(Calendar.MILLISECOND, 0);
						birth = new java.sql.Date(calendar.getTimeInMillis());
						
						
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
		}
		contentsdatadao.contentsdataUpdate(contentsdatabean.getContentsID(), contentsdatabean.getContentsdataID(), name, is, intro, sex, birth);
		request.setAttribute("id",contentsdatabean.getContentsID() );
		System.out.println(contentsdatabean.getContentsID());
		request.getRequestDispatcher("GetAllContentsdata").forward(request, response);
	}

}
