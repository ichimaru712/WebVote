package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.And;

import model.MypageVotehistoryBean;
import model.VotehistoryBean;
import servlet.GetVotehistory;

public class VotehistoryDAO extends DaoBase{
	
	//ユーザーごとの履歴取得
	public ArrayList<VotehistoryBean> getUserVotehistory(String id){
		ArrayList<VotehistoryBean> votearray = new ArrayList<VotehistoryBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from votehistory where userID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				VotehistoryBean votehistoryBean = new VotehistoryBean();
				
				votehistoryBean.setVotehistoryID(rs.getInt("votehistoryID"));
				votehistoryBean.setContentsID(rs.getString("contentsID"));
				votehistoryBean.setContentsdataID(rs.getString("contentsdataID"));
				votehistoryBean.setVotedate(rs.getDate("voteDate"));

				votearray.add(votehistoryBean);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return votearray;
	}
	
	//ユーザが対象コンテンツに投票済みか確認
	public int getContentsVoteCheck(String userID,String contentsID){
		int check = 0;
		try{
			//super.DbOpen();
			super.connection();
			
			String sql = "select count(*) from votehistory where userID = ? and contentsID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userID);
			stmt.setString(2, contentsID);
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
			System.out.println(e);
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
			
			String sql ="select count(*) from votehistory v,user u where v.contentsID = ? and u.sex = '男' and u.authority = 'U'";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, contentsid);
			rs=stmt.executeQuery();
			rs.next();
			
			count = rs.getInt(1);
			
		}catch(Exception e){
			System.out.println(e);
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
				
				String sql ="select count(*) from votehistory v,user u where v.contentsID = ? and u.sex = '女' and u.authority = 'U'";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, contentsid);
				rs=stmt.executeQuery();
				rs.next();
				
				count = rs.getInt(1);
				
			}catch(Exception e){
				System.out.println(e);
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
