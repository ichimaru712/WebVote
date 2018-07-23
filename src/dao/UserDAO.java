package dao;

import java.util.ArrayList;

import model.UserBean;

public class UserDAO extends DaoBase {

	public UserBean getUser(String id){
		UserBean user = new UserBean();
		try{
		super.connection();

		String sql ="select * from user where userID = ?";
		stmt = con.prepareStatement(sql);

		stmt.setString(1, id);
		rs=stmt.executeQuery();
		rs.next();

		user.setUserID(rs.getString(1));
		user.setUserName(rs.getString(2));
		user.setCreateDate(rs.getDate(3));
		user.setAuthority(rs.getString(4));
		user.setSex(rs.getString(5));
		user.setBirthday(rs.getDate(6));
		return user;
		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return null;
		//ユーザが見つかれば該当ユーザ情報を、いなければnullをかえす
	}
	
	public ArrayList<UserBean> getAllUser() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try{
		super.connection();

		String sql ="select * from user";
		stmt = con.prepareStatement(sql);
		rs=stmt.executeQuery();
		while(rs.next()) {
		UserBean user = new UserBean();
		user.setUserID(rs.getString(1));
		user.setUserName(rs.getString(2));
		user.setCreateDate(rs.getDate(3));
		user.setAuthority(rs.getString(4));
		user.setSex(rs.getString(5));
		user.setBirthday(rs.getDate(6));
		users.add(user);
		}
		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return users;
		
	}

	public void userInsert(UserBean user){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into user(userID,userName,sex,birthday) values(?,?,?,?)";

			stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getUserID());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getSex());
			stmt.setDate(4, user.getBirthday());

			rsno = stmt.executeUpdate();

		}catch(Exception e){
			user=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

	//管理者からのユーザ情報変更
	public void userUpdate(UserBean user){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="Update user set userName=?,sex=?,birthday=? where userID = ?";

			stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getSex());
			stmt.setDate(3, user.getBirthday());
			stmt.setString(4, user.getUserID());

			rsno = stmt.executeUpdate();

		}catch(Exception e){
			user=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

	//一般ユーザからのユーザ情報変更
	public void userNameUpdate(String id,String name){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="Update user set userName=? where userID = ?";

			stmt = con.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2, id);


			rsno = stmt.executeUpdate();

		}catch(Exception e){
			id = null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}

	public void userDelete(String id){
		try{
			//super.DbOpen();
			super.connection();

			String sql ="Delete from user where userID = ?";
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

}
