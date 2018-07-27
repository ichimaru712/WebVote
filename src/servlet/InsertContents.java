package servlet;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(maxFileSize=1048576)
public class InsertContents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
		
		String id = RandomStringUtils.randomAlphabetic(10)+RandomStringUtils.randomNumeric(10);//ランダム生成
		String name = request.getParameter("name");
		
		java.sql.Date start = null;
		Date end = null;
		try{
			// String → java.util.Date → java.sql.Date
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			String str_start = request.getParameter("start");
			String str_end = request.getParameter("end");
			
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
			
		}catch (Exception e) {
			System.out.println(e);
		}
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("picture");
		if (filePart != null) {
			is = filePart.getInputStream();
		}
		
		ContentsBean contentsbean = new ContentsBean(id, name, null, start, end, is);
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedImage bi = ImageIO.read(bis);
		
		session.setAttribute("insertcontents",contentsbean);
		session.setAttribute("insertcontentspicture",bi);
		//フォワード画面入力予定
		request.getRequestDispatcher("manager_contentsAddCheck.jsp").forward(request, response);
	}

}
