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
import model.ContentsBean;

/**
 * Servlet implementation class UpdateContents
 */
@WebServlet("/UpdateContents")
@MultipartConfig(maxFileSize=1048576)
public class UpdateContents extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContents() {
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
		String id = request.getParameter("id");
		ContentsDAO contentsdao = new ContentsDAO();
		ContentsBean updatecontents = new ContentsBean();

		updatecontents = contentsdao.getContents(id);

		session.setAttribute("updatecontents", updatecontents);

		request.getRequestDispatcher("manager_contentsUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ContentsDAO contentsdao = new ContentsDAO();
		ContentsBean contentsbean = (ContentsBean)session.getAttribute("updatecontents");

		String name = request.getParameter("contentsName");
		String str_start = request.getParameter("start");
		String str_end = request.getParameter("end");
		
		Date start = null;
		Date end = null;
		try{
			// String → java.util.Date → java.sql.Date
						SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
						

						
						// input type="date"の値から余計な文字列を削除
						str_start = str_start.replace("T", " ");
						str_end = str_end.replace("T", " ");
						
						java.util.Date util_start = new java.util.Date();
						java.util.Date util_end = new java.util.Date();
						
						// String → java.util.Date
						util_start = sFormat.parse(str_start);
						util_end = sFormat.parse(str_end);
						
						// java.util.Date → java.sql.Date
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(util_start);
						calendar.set(Calendar.HOUR_OF_DAY, 0);
						calendar.set(Calendar.MINUTE, 0);
						calendar.set(Calendar.SECOND, 0);
						calendar.set(Calendar.MILLISECOND, 0);
						start = new java.sql.Date(calendar.getTimeInMillis());
						
						calendar.setTime(util_end);
						end = new java.sql.Date(calendar.getTimeInMillis());
						
						//画像挿入処理
						InputStream is= null;
						Part filePart = request.getPart("picture");
						if (filePart != null) {
							is = filePart.getInputStream();
							contentsdao.contentsUpdate(contentsbean.getContentsID(), name, start, end, is);
						}else{
							contentsdao.contentsUpdateBlob(contentsbean.getContentsID(), name, start, end);
						}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		


		request.getRequestDispatcher("GetContents").forward(request, response);
	}

}
