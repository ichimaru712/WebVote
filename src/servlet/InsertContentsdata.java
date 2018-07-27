package servlet;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    
    public InsertContentsdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();
		
		ContentsdataBean contentsdatabean = (ContentsdataBean)session.getAttribute("insertcontentsdata");
		contentsdatadao.contentsdataInsert(contentsdatabean.getContentsID(), contentsdatabean.getContentsdataID(), contentsdatabean.getContentsdataName(), (InputStream)contentsdatabean.getContentsdataPicture(), contentsdatabean.getIntroduction(), contentsdatabean.getSex(), contentsdatabean.getBirthday());
		
		request.getRequestDispatcher("GetAllContentsdata").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
				
		String c_id = (String) session.getAttribute("contentsID");
		String d_id = RandomStringUtils.randomAlphabetic(10)+RandomStringUtils.randomNumeric(10);//ランダム生成
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String intro = request.getParameter("intro");
		
		Date birthday = null;
		try {
			// String → java.util.Date → java.sql.Date
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			String birth = request.getParameter("birthday");
			
			java.util.Date util_day = new java.util.Date();
			
			// String → java.util.Date
			util_day = sFormat.parse(birth);
			
			// java.util.Date → java.sql.Date
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(util_day);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			birthday = new java.sql.Date(calendar.getTimeInMillis());
			
		} catch (ParseException e) {
			System.out.println("[InsertContentsdata]ERROR:ParseException");
		}
		
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
		}
		
		BufferedInputStream bis = new BufferedInputStream(is);
		
		
		
		//フォワード画面入力予定
		request.getRequestDispatcher(".jsp").forward(request, response);
	}

}
