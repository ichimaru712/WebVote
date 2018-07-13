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

import dao.ContentsdataDAO;
import model.ContentsBean;
import model.ContentsdataBean;

/**
 * Servlet implementation class InsertContentsdata
 */
@WebServlet("/InsertContentsdata")
public class InsertContentsdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertContentsdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();
		
		ContentsdataBean contentsdatabean = (ContentsdataBean)session.getAttribute("insertcontentsdata");
		contentsdatadao.contentsdataInsert(contentsdatabean.getContentsID(), contentsdatabean.getContentsdataID(), contentsdatabean.getContentsdataName(), (InputStream)contentsdatabean.getContentsdataPicture(), contentsdatabean.getIntroduction(), contentsdatabean.getSex(), contentsdatabean.getBirthday());
		
		request.getRequestDispatcher("GetAllContentsdata").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String c_id = request.getParameter("c_id");
		String d_id = RandomStringUtils.randomAlphabetic(10)+RandomStringUtils.randomNumeric(10);//ランダム生成
		String name = request.getParameter("name");
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
		}
		String intro = request.getParameter("intro");
		String sex = request.getParameter("sex");
		Date birth = Date.valueOf(request.getParameter("birth"));
		
		ContentsdataBean contentsdatabean = new ContentsdataBean(c_id, d_id, name, (Blob) is, intro, sex, birth);
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedImage bi = ImageIO.read(bis);
		
		session.setAttribute("insertcontentsdata",contentsdatabean);
		session.setAttribute("insertcontentsdatapicture",bi);
		
		//フォワード画面入力予定
		request.getRequestDispatcher(".jsp").forward(request, response);
	}

}
