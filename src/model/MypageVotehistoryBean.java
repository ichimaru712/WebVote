package model;

import java.io.Serializable;
import java.sql.Date;

public class MypageVotehistoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String contentsname;
	private String contentsdatename;
	private Date votedate;

	public MypageVotehistoryBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getContentsname() {
		return contentsname;
	}

	public void setContentsname(String contentsname) {
		this.contentsname = contentsname;
	}

	public String getContentsdatename() {
		return contentsdatename;
	}

	public void setContentsdatename(String contentsdatename) {
		this.contentsdatename = contentsdatename;
	}

	public Date getVotedate() {
		return votedate;
	}

	public void setVotedate(Date string) {
		this.votedate = string;
	}
}
