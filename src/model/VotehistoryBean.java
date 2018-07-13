package model;

import java.io.Serializable;
import java.sql.Date;

public class VotehistoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String votehistoryID;
	private String userID;
	private String contentsID;
	private String contentsdataID;
	private Date votedate;

	public VotehistoryBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public VotehistoryBean(String votehistoryID,String userID,String contentsID,String contentsdataID,Date votedate) {
		this.votehistoryID = votehistoryID;
		this.userID = userID;
		this.contentsID = contentsID;
		this.contentsdataID = contentsdataID;
		this.votedate = votedate;
	}

	public String getVotehistoryID() {
		return votehistoryID;
	}

	public void setVotehistoryID(String votehistory) {
		this.votehistoryID = votehistory;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getContentsID() {
		return contentsID;
	}

	public void setContentsID(String contentsID) {
		this.contentsID = contentsID;
	}

	public String getContentsdataID() {
		return contentsdataID;
	}

	public void setContentsdataID(String contentsdataID) {
		this.contentsdataID = contentsdataID;
	}

	public Date getVotedate() {
		return votedate;
	}

	public void setVotedate(Date votedate) {
		this.votedate = votedate;
	}

}
