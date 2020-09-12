package dao;

import java.sql.*;
import dto.*;
import java.util.*;

public class ReservationDAO {
	// DAO class에서 사용될 공유 Connection 객체
	private static Connection connection;
	
	// singleton pattern applied default constructor
	private ReservationDAO() {}
	
	// declaring Lazy-Holder (중첩 클래스)
	private static class LazyHolder {
		/* static: 클래스 로딩 시점에 한번만 호출
		 * final: 값이 다시 할당되지 않음 */
		private static final ReservationDAO instance = new ReservationDAO();
	}
	
	// getInstance method 호출 시 LazyHolder 호출
	public static ReservationDAO getInstance() {
		return LazyHolder.instance;
	}
	
	// database (MySQL)과 연동시켜 관련 정보를 static Connection instance에 저장
	public void dbConnect() {
		final String id = "admin";
		final String password = "qortjf90";
		final String accessURL = "jdbc:mysql://34.64.246.18:3306/"
				+ "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul"
				+ "&allowPublicKeyRetrieval=true&useSSL=false";
		final String dbName = "resort";
		
		try {
			/* jsp에서는 Class.forName 코드를 사용하지 않으면 Connection이 이루어 지지 않는다. */
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(accessURL, id, password);
			connection.setCatalog(dbName); // using database
		} catch (ClassNotFoundException e) {
			// Class.forName method에서 발생가능한 ClassNotFoundException catch
			e.printStackTrace();	
		} catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
	
	public void connectionTest() {
		dbConnect(); // database Connection 생성
		Statement statement;
		ResultSet resultSet;
		// SELECT query문 
		String query = "show databases;";
		
		try {
			if(connection != null) {

				statement = connection.createStatement();
				
				/* executeQuery: SELECT문만 실행 가능
				 * return: ResultSet object */
				resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					System.out.println(resultSet.getString(1));
				}
				// object closing part
				statement.close();
				resultSet.close();
				connection.close();
			} else {
				System.out.println("Connection isNull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ReservationDTO> selectMonthList(int month) {
		List<ReservationDTO> resvInformList = new ArrayList<>();
		dbConnect();
		Statement statement;
		ResultSet resultSet;
		String query = "select * from reservation where MONTH(resv_date) = " + month;
		
		try {
			if(connection != null) {

				statement = connection.createStatement();
				ReservationDTO resvInform = new ReservationDTO();
				/* executeQuery: SELECT문만 실행 가능
				 * return: ResultSet object */
				resultSet = statement.executeQuery(query);
				while(resultSet.next()) {
					resvInform.setName(resultSet.getString("name"));
					resvInform.setDate(resultSet.getDate("resv_date"));
					resvInform.setRoom(resultSet.getInt("room"));
					resvInform.setAddr(resultSet.getString("addr"));
					resvInform.setPhone(resultSet.getString("phone"));
					resvInform.setPayer(resultSet.getString("payer"));
					resvInform.setComment(resultSet.getString("comment"));
					resvInform.setWriteDate(resultSet.getDate("write_date"));
					resvInform.setProcessing(resultSet.getInt("processing"));
					resvInformList.add(resvInform);
				}
				// object closing part
				statement.close();
				resultSet.close();
				connection.close();
			} else {
				System.out.println("Connection isNull");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resvInformList;
	}
}
