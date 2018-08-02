package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Date;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.ContentsBean;
//変更
public class ContentsDAO extends DaoBase {

	//すべてのコンテンツを取得
	public ArrayList<ContentsBean> getAllContents(){
		ArrayList<ContentsBean> arraycontents = new ArrayList<ContentsBean>();
		try{
			//super.DbOpen();
			super.connection();

			String sql  ="select * from contents";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();

			while(rs.next()){
				ContentsBean contentsbean = new ContentsBean();

			    contentsbean.setContentsID(rs.getString("contentsID"));
			    contentsbean.setContentsName(rs.getString("contentsName"));
			    contentsbean.setContentsDate(rs.getDate("contentsDate"));
			    contentsbean.setStartDate(rs.getDate("startDate"));
			    contentsbean.setEndDate(rs.getDate("endDate"));
			    contentsbean.setContentsPicture(rs.getBinaryStream("contentsPicture"));

				arraycontents.add(contentsbean);
			}

		}catch(Exception e){
			return null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return arraycontents;
	}
	
	// 開催中・開催前のコンテンツのみ取得
	public ArrayList<ContentsBean> getActiveContents(Date date){
		ArrayList<ContentsBean> activeContents = new ArrayList<ContentsBean>();
		try {
			//super.DbOpen();
			super.connection();

			String sql  ="select * from contents where (? >= startDate and ? <= endDate) or (startDate > ?)";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1,date);
			stmt.setDate(2,date);
			stmt.setDate(3,date);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				ContentsBean contentsbean = new ContentsBean();

			    contentsbean.setContentsID(rs.getString("contentsID"));
			    contentsbean.setContentsName(rs.getString("contentsName"));
			    contentsbean.setContentsDate(rs.getDate("contentsDate"));
			    contentsbean.setStartDate(rs.getDate("startDate"));
			    contentsbean.setEndDate(rs.getDate("endDate"));
			    contentsbean.setContentsPicture(rs.getBinaryStream("contentsPicture"));

				activeContents.add(contentsbean);
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
		return activeContents;
	}
	
	
	// 開催終了したコンテンツのみ取得
	public ArrayList<ContentsBean> getNoActiveContents(Date date){
		ArrayList<ContentsBean> noactiveContents = new ArrayList<ContentsBean>();
		try {
			//super.DbOpen();
			super.connection();

			String sql  ="select * from contents where endDate < ?";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1,date);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				ContentsBean contentsbean = new ContentsBean();

			    contentsbean.setContentsID(rs.getString("contentsID"));
			    contentsbean.setContentsName(rs.getString("contentsName"));
			    contentsbean.setContentsDate(rs.getDate("contentsDate"));
			    contentsbean.setStartDate(rs.getDate("startDate"));
			    contentsbean.setEndDate(rs.getDate("endDate"));
			    contentsbean.setContentsPicture(rs.getBinaryStream("contentsPicture"));

				noactiveContents.add(contentsbean);
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
		return noactiveContents;
	}
	
	// 履歴テーブルから取得したcontentsIDで、コンテンツテーブルからcontentsNameを取得
	public String getContentsName(String id){
		String contentsID = "";
		try {
			super.connection();
			
			String sql = "select contentsName from contents where contentsID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			rs.next();
			
			contentsID = rs.getString("contentsName");
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return contentsID;
	}

	//現在開催中のコンテンツを取得
	public ArrayList<ContentsBean> getInSessionContents(Date nowtime){
		ArrayList<ContentsBean> arraycontents = new ArrayList<ContentsBean>();
		try{
			//super.DbOpen();
			super.connection();

			String sql  ="select * from contents where trunc(?) >= startDate and trunc(?) <= endDate";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, nowtime);
			rs=stmt.executeQuery();

			while(rs.next()){
				ContentsBean contentsbean = new ContentsBean();

			    contentsbean.setContentsID(rs.getString("contentsID"));
			    contentsbean.setContentsName(rs.getString("contentsName"));
			    contentsbean.setContentsDate(rs.getDate("contentsDate"));
			    contentsbean.setStartDate(rs.getDate("startDate"));
			    contentsbean.setEndDate(rs.getDate("endDate"));
			    contentsbean.setContentsPicture(rs.getBinaryStream("contentsPicture"));

				arraycontents.add(contentsbean);
			}

		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return arraycontents;
	}

	//指定したコンテンツ1件の情報を取得
	public ContentsBean getContents(String id){
		ContentsBean contentsbean = new ContentsBean();
		try{
			//super.DbOpen();
			super.connection();

			String sql  ="select * from contents where contentsID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();

			rs.next();

			contentsbean.setContentsID(rs.getString("contentsID"));
			contentsbean.setContentsName(rs.getString("contentsName"));
			contentsbean.setContentsDate(rs.getDate("contentsDate"));
			contentsbean.setStartDate(rs.getDate("startDate"));
			contentsbean.setEndDate(rs.getDate("endDate"));
			contentsbean.setContentsPicture(rs.getBinaryStream("contentsPicture"));


		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return contentsbean;
	}

	public void contentsInsert(String id,String name,Date start,Date end,InputStream picture){

		try{
//			FileChannel channel = picture.getChannel();
//            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
//            channel.read(buffer);
//            buffer.clear();
//            byte[] bytes = new byte[buffer.capacity()];
//            buffer.get(bytes);
//            channel.close();
			//super.DbOpen();
			super.connection();
			String sql  ="insert into contents(contentsID,contentsName,startDate,endDate,contentsPicture) values(?,?,?,?,?)";

			stmt = con.prepareStatement(sql);

			stmt.setString(1, id);
			stmt.setString(2, name);
			stmt.setDate(3, start);
			stmt.setDate(4, end);
			stmt.setBlob(5, picture);

			rsno = stmt.executeUpdate();

		}catch(Exception e){
			System.out.println(e);

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

	public void contentsUpdate(String id,String name,Date start,Date end,InputStream picture){
		try{
			//super.DbOpen();
			super.connection();

			String sql ="Update contents set contentsName=?,startDate=?,endDate=?,contentsPicture=? where contentsID = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setDate(2, start);
			stmt.setDate(3, end);
			stmt.setBlob(4, picture);
			stmt.setString(5, id);
			rsno=stmt.executeUpdate();

			}catch(Exception e){

			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
	}

	public void contentsUpdateBlob(String id,String name,Date start,Date end){
		try{
			//super.DbOpen();
			super.connection();

			String sql ="Update contents set contentsName=?,startDate=?,endDate=? where contentsID = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setDate(2, start);
			stmt.setDate(3, end);
			stmt.setString(4, id);
			rsno=stmt.executeUpdate();

			}catch(Exception e){

			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
	}

	public void contentsDelete(String id){
		try{
			//super.DbOpen();
			super.connection();

			String sql ="Delete from contents where contentsID = ?";
			stmt = con.prepareStatement(sql);

			stmt.setString(1,id);
			rsno=stmt.executeUpdate();

			}catch(Exception e){

			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
	}

	//画像取得
	public BufferedImage getPicture(String id){
		try{
		   super.connection();
		   String sql  ="select * from contents where contentsID = ?";
		   stmt = con.prepareStatement(sql);
		   stmt.setString(1, id);
		   rs = stmt.executeQuery();
		   rs.next();
		   InputStream is = rs.getBinaryStream("contentsPicture");
		   BufferedInputStream bis = new BufferedInputStream(is);
		   return ImageIO.read(bis);

		}catch(Exception e){
			System.out.println(e);

		}finally {
		   try{
		    super.DbClose();
		   }catch(Exception e){
		    System.out.println("error");
		   }
		}
		  return null;
	}
}
