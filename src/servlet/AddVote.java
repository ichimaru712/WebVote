package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotehistoryDAO;
import model.ContentsdataBean;
import model.UserBean;

@WebServlet("/AddVote")
public class AddVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserBean userBean = (UserBean)session.getAttribute("loginUser");
		ContentsdataBean contentsdataBean = (ContentsdataBean)session.getAttribute("contentsdataBean");
		
		VotehistoryDAO votehistoryDAO = new VotehistoryDAO();
		
		//ユーザが対象コンテンツに投票済みか確認 *二重チェック
		int check = votehistoryDAO.getContentsVoteCheck(userBean.getUserID(), contentsdataBean.getContentsID(), contentsdataBean.getContentsdataID());
		
		String path = "";
		if(check == 0){
			//未投票
			//投票処理
			votehistoryDAO.voteInsert(userBean.getUserID(), contentsdataBean.getContentsID(), contentsdataBean.getContentsdataID());
			path = "votecompletion.jsp";
		}else{
			//投票済
			session.setAttribute("voteCheck", 1);
			path = "contentsdata.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
