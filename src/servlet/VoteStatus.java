package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotehistoryDAO;
import model.ContentsBean;


@WebServlet("/VoteStatus")
public class VoteStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		VotehistoryDAO votehistoryDAO = new VotehistoryDAO();
		
		String id = request.getParameter("id");
		
		//対象コンテンツの総投票数取得
		int allvote = votehistoryDAO.getContentsVotehistory(id);
		//性別ごとの投票数取得
		int man = votehistoryDAO.getContentsManVotehistory(id);
		int woman = votehistoryDAO.getContentsWomanVotehistory(id);
		
		session.setAttribute("allvote", allvote);
		session.setAttribute("man", man);
		session.setAttribute("woman", woman);
		
		request.getRequestDispatcher("votestatus.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
