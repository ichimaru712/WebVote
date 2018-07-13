package servlet;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.lang3.RandomStringUtils;

import dao.ContentsDAO;
import dao.ContentsdataDAO;
import model.ContentsBean;
import model.ContentsdataBean;

/**
 * Servlet implementation class InsertContents
 */
@WebServlet("/InsertContents")
public class InsertContents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertContents() {
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
		ContentsDAO contentsdao = new ContentsDAO();
		
		ContentsBean contentsbean = (ContentsBean)session.getAttribute("insertcontents");
		contentsdao.contentsInsert(contentsbean.getContentsID(), contentsbean.getContentsName(), contentsbean.getStartDate(), contentsbean.getEndDate(), (InputStream)contentsbean.getContentsPicture());;
		
		request.getRequestDispatcher("GetContents").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
		
		String id = RandomStringUtils.randomAlphabetic(10)+RandomStringUtils.randomNumeric(10);//ランダム生成
		String name = request.getParameter("name");
		Date start = Date.valueOf(request.getParameter("start"));
		Date end = Date.valueOf(request.getParameter("end"));
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
		}
		
		ContentsBean contentsbean = new ContentsBean(id, name, null, start, end, (Blob)is);
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedImage bi = ImageIO.read(bis);
		
		session.setAttribute("insertcontents",contentsbean);
		session.setAttribute("insertcontentspicture",bi);
		//フォワード画面入力予定
		request.getRequestDispatcher("manager_contentsAddCheck.jsp").forward(request, response);
	}

}
