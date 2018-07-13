package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContentsDAO;
import dao.ContentsdataDAO;

/**
 * Servlet implementation class DeleteContentsdata
 */
@WebServlet("/DeleteContentsdata")
public class DeleteContentsdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContentsdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contentsid = request.getParameter("c_id");
		String contentsdataid = request.getParameter("d_id");
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();
		
		contentsdatadao.contentsdataDelete(contentsid,contentsdataid);
		
		request.setAttribute("id", contentsid);
		
		request.getRequestDispatcher("GetAllContentsdata").forward(request, response);
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
