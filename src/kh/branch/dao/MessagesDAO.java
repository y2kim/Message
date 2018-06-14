package kh.branch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kh.branch.dto.Message;

public class MessagesDAO {
	
	// 싱글턴, connection pool 사용	
		private Connection con;
		
		private Connection getConnection() throws SQLException, NamingException {

				  Context context = new InitialContext();
				  DataSource ds = (DataSource) context.lookup("java:/comp/env/oracle");
				  return ds.getConnection();
		}
		

		public int insertOneMessage(Message message) throws SQLException, NamingException {
			
			/*
			message_id number primary key,
    		name varchar(20) not null,
    		message varchar(200) not null
    		
    		seq: message_id_seq
			 */
			
			this.con = this.getConnection();
			String sql = "insert into messages values(message_id_seq .nextval, ?, ?)";
			
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, message.getName());
				ps.setString(2, message.getMessage());
				
				int result = ps.executeUpdate();
				
				con.commit();
				
				return result;
				
			} catch(SQLException e ) {
				con.rollback();
				throw e;
			} finally {
				con.close();
			}
		}
		
		public List<Message> getAllMessages() throws SQLException, NamingException {
			
			// seq number primary key, name varchar(20) not null, contact varchar(20) not null;
			
			this.con = this.getConnection();
			String sql = "select * from messages";
			
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				
				List<Message> list = new ArrayList<>();
				ResultSet rs = ps.getResultSet();
				
				Message message = null;
				while(rs.next()) {
					message = new Message();
					message.setMessageId(rs.getInt(1));
					message.setName(rs.getString(2));
					message.setMessage(rs.getString(3));
					list.add(message);
				}
		
				return list;
				
			} catch(SQLException e ) {
				throw e;
			} finally {
				con.close();
			}
		}
}
