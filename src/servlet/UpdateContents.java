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
import model.ContentsBean;

/**
 * Servlet implementation class UpdateContents
 */
@WebServlet("/UpdateContents")
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

		String name = request.getParameter("name");
		Date start = Date.valueOf(request.getParameter("start"));
		Date end = Date.valueOf(request.getParameter("end"));
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
			contentsdao.contentsUpdate(contentsbean.getContentsID(), name, start, end, is);
		}else{
			contentsdao.contentsUpdateBlob(contentsbean.getContentsID(), name, start, end);
		}


		request.getRequestDispatcher("GetContents").forward(request, response);
	}

}
