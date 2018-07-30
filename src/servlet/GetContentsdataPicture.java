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
import dao.ContentsdataDAO;

/**
 * Servlet implementation class GetContentsdataPicture
 */
@WebServlet("/GetContentsdataPicture")
public class GetContentsdataPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetContentsdataPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");//商品のidを取得
		String id2 = request.getParameter("id2");//商品のidを取得
		ContentsdataDAO contentsdatadao = new ContentsdataDAO();//daoの用意
		HttpSession session = request.getSession();
		BufferedImage img;
		if(session.getAttribute("bi")!=null){
			img = (BufferedImage)session.getAttribute("bi");
			session.removeAttribute("bi");
		}else{
			img =  contentsdatadao.getPicture(id, id2);
		}
		
		// 画像をクライアントに返却する
		response.setContentType("image/jpeg");//画像の型指定
		OutputStream os = response.getOutputStream();//レスポンスから画像のセット
		ImageIO.write(img, "jpg", os);//表示
		os.flush();//jspに返す
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
