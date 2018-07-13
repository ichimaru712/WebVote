package dao;

import java.sql.Date;
import java.util.ArrayList;

import model.VotehistoryBean;

public class VotehistoryDAO extends DaoBase{
	
	//ユーザーごとの履歴取得
	public ArrayList<VotehistoryBean> getUserVotehistory(String id){
		ArrayList<VotehistoryBean> arrayvotehistory = new ArrayList<VotehistoryBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from votehistory where userID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				VotehistoryBean votehistorybean = new VotehistoryBean();
				
				votehistorybean.setVotehistoryID(rs.getString("votehistoryID"));
				votehistorybean.setUserID(rs.getString("userID"));
				votehistorybean.setContentsID(rs.getString("contentsID"));
				votehistorybean.setContentsdataID(rs.getString("contentsdataID"));
				votehistorybean.setVotedate(rs.getDate("votedate"));
				
				arrayvotehistory.add(votehistorybean);
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return arrayvotehistory;
	}
	
	//ユーザが対象コンテンツに投票済みか確認
	public int getContentsVoteCheck(String userID,String contentsID,String contentsdataID){
		int check = 0;
		try{
			//super.DbOpen();
			super.connection();
			
			String sql = "select count(*) from votehistory where userID = ? and contentsID = ? and contentsdataID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userID);
			stmt.setString(2, contentsID);
			stmt.setString(3, contentsdataID);
			rs = stmt.executeQuery();
			rs.next();
			
			check = rs.getInt(1);
 			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		
		return check;
	}
	
	//コンテンツごとの投票数取得
	public int getContentsVotehistory(String id){
		int count = -1;
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="select count(*) from votehistory where contentsID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			rs.next();
			
			count = rs.getInt(1);
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return count;
	}
	
	//対象コンテンツの男性の投票数取得
	public int getContentsManVotehistory(String contentsid){
		int count = -1;
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="select count(*) from votehistory where contentsID = ? and sex = '男'";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, contentsid);
			rs=stmt.executeQuery();
			rs.next();
			
			count = rs.getInt(1);
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return count;
	}
	
	//対象コンテンツの女性の投票数取得
		public int getContentsWomanVotehistory(String contentsid){
			int count = -1;
			try{
				//super.DbOpen();
				super.connection();
				
				String sql ="select count(*) from votehistory where contentsID = ? and sex = '女'";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, contentsid);
				rs=stmt.executeQuery();
				rs.next();
				
				count = rs.getInt(1);
				
			}catch(Exception e){
				
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
			return count;
		}
	
	//コンテンツ詳細ごとの投票数取得
	public int getContentsdataVotehistory(String contentsid,String contentsdataid){
		int count = -1;
		try{
			//super.DbOpen();
			super.connection();
					
			String sql  ="select count(*) from votehistory where contentsID = ? and contentsdataID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, contentsid);
			stmt.setString(2, contentsdataid);
			rs=stmt.executeQuery();
			rs.next();
					
			count = rs.getInt(1);
					
		}catch(Exception e){
					
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return count;
	}
	
	//投票
	public void voteInsert(String userid,String contentsid,String contentsdataid){
		
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into votehistory (userID,contentsID,contentsdataID) values(?,?,?)";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, userid);
			stmt.setString(2, contentsid);
			stmt.setString(3, contentsdataid);
			
			rsno = stmt.executeUpdate();
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}
}
