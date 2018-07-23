package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentsDAO;


@WebServlet("/GetContentsPicture")
public class GetContentsPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");//商品のidを取得
		ContentsDAO contentsdao = new ContentsDAO();//daoの用意
		HttpSession session = request.getSession();
		BufferedImage img = contentsdao.getPicture(id);
		/*
		if(session.getAttribute("bi")!=null){
			img = (BufferedImage)session.getAttribute("bi");
			session.removeAttribute("bi");
		}else{
			img = contentsdao.getPicture(id);
		}
		*/
		
		// 画像をクライアントに返却する
		response.setContentType("image/jpeg");//画像の型指定
		OutputStream os = response.getOutputStream();//レスポンスから画像のセット
		ImageIO.write(img, "jpg", os);//表示
		os.flush();//jspに返す
	}
}
