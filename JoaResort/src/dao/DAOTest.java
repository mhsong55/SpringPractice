package dao;

public class DAOTest {

	public static void main(String[] args) {
		ReservationDAO dao = ReservationDAO.getInstance();
		
		System.out.println(dao.selectMonthList(8).size());
	}

}
