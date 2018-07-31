package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentsDAO;
import dao.ContentsdataDAO;
import dao.VotehistoryDAO;
import model.MypageVotehistoryBean;
import model.UserBean;
import model.VotehistoryBean;


@WebServlet("/GetVotehistory")
public class GetVotehistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetVotehistory() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean)session.getAttribute("loginUser");
		
		VotehistoryDAO votehistoryDAO = new VotehistoryDAO();
		ArrayList<VotehistoryBean> historyarray = votehistoryDAO.getUserVotehistory(userBean.getUserID());
		
		ArrayList<MypageVotehistoryBean> votearray = new ArrayList<MypageVotehistoryBean>();
		for(int i = 0; i < historyarray.size(); i++){
			// 履歴テーブルから取得したcontentsIDで、コンテンツテーブルからcontentsNameを取得
			ContentsDAO contentsDAO = new ContentsDAO();
			String contentsName = contentsDAO.getContentsName(historyarray.get(i).getContentsID());
			
			// 履歴テーブルから取得したcontentsdataIDで、コンテンツテーブルからcontentsdataNameを取得
			ContentsdataDAO contentsdataDAO = new ContentsdataDAO();
			String contentsdataName = contentsdataDAO.getContentsdataName(historyarray.get(i).getContentsID(), historyarray.get(i).getContentsdataID());
			
			Date date = historyarray.get(i).getVotedate();
			
			MypageVotehistoryBean myp = new MypageVotehistoryBean();
			
			myp.setContentsname(contentsName);
			myp.setContentsdatename(contentsdataName);
			myp.setVotedate(date);
			
			votearray.add(myp);
		}
		
		session.setAttribute("votearray", votearray);
		
		request.getRequestDispatcher("votehistory.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
