package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentsDAO;
import model.ContentsBean;

/**
 * Servlet implementation class InsertContentsDB
 */
@WebServlet("/InsertContentsDB")
public class InsertContentsDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ContentsDAO contentsdao = new ContentsDAO();
		
		ContentsBean contentsbean = (ContentsBean)session.getAttribute("insertcontents");
		contentsdao.contentsInsert(contentsbean.getContentsID(), contentsbean.getContentsName(), contentsbean.getStartDate(), contentsbean.getEndDate(), contentsbean.getContentsPicture());
		
		request.getRequestDispatcher("GetContents").forward(request, response);
	}

}
