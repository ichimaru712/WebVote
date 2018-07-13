package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentsDAO;
import dao.ContentsdataDAO;

/**
 * Servlet implementation class DeleteContents
 */
@WebServlet("/DeleteContents")
public class DeleteContents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String contentsid = request.getParameter("c_id");
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();
		ContentsDAO contentsdao = new ContentsDAO();
		
		contentsdatadao.contentsdataAllDelete(contentsid);
		contentsdao.contentsDelete(contentsid);
		
		
		request.getRequestDispatcher("GetContents").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
