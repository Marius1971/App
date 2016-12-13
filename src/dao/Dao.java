package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Ceas;

public class Dao {
	private static Connection con;
	private static java.sql.Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	//static List<Ceas>ceasuri= new ArrayList<Ceas>();
	
	
	
	// Creaza conexiunea la Baza de date
	public static void creazaConexiunea() {
		try {
			Class driver = Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ceasuri", "root", "");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Nu s-a gasit clasa Driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nu s-a gasit serverul de date");
		}
	}

	// Inchide resursele
	private static void inchideResursele() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Conexiunea nu a putut fi inchisa");
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Am incercat sa inchid dar nu am reusit" + e);
			}
		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Nu s-a reusit inchiderea resursei" + e);
			}
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Am intampinat o eroare" + e);
			}
		}

	}

	// Afiseaza ceasurile
	public static List<Ceas> afiseazaCeasuri() {

		creazaConexiunea();
		try {
			statement = con.createStatement();
			String sql = "SELECT * FROM ceasuri";
			resultSet = statement.executeQuery(sql);

			List<Ceas> ceasuri = new ArrayList<Ceas>();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String marca = resultSet.getString("marca");
				String model = resultSet.getString("model");
				String gen = resultSet.getString("gen");
				String calibru = resultSet.getString("calibru");
				String material = resultSet.getString("material");
				String curea = resultSet.getString("curea");
				String mecanism = resultSet.getString("mecanism");
				String geam = resultSet.getString("geam");
				double pret = resultSet.getDouble("pret");
				int stoc = resultSet.getInt("stoc");
				String detalii = resultSet.getString("detalii");
				String img = resultSet.getString("img");
				
				ceasuri.add(
						new Ceas(id, marca, model, gen, calibru, material, curea, mecanism, geam, pret, stoc, detalii, img));
			}
			return ceasuri;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nu s-a efectuat interogarea");
			return null;
		} finally {
			inchideResursele();
		}

	}

	public Ceas afiseazaDetalii(int id) {
		return afiseazaCeasuri().get(id-1);
	}
	

	// Adauga ceas
	public static boolean insereazaCeas(Ceas ceasuri) {
		creazaConexiunea();
		String query = "INSERT INTO ceasuri (marca, model, gen, calibru, curea, mecanism, geam, pret, stoc, detalii, img)VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, ceasuri.getMarca());
			preparedStatement.setString(2, ceasuri.getModel());
			preparedStatement.setString(3, ceasuri.getGen());
			preparedStatement.setInt(4, Integer.parseInt( ceasuri.getCalibru()) );
			preparedStatement.setString(5, ceasuri.getCurea());
			preparedStatement.setString(6, ceasuri.getMecanism());
			preparedStatement.setString(7, ceasuri.getGeam());
			preparedStatement.setDouble(8, ceasuri.getPret());
			preparedStatement.setInt(9, ceasuri.getStoc());
			preparedStatement.setString(10, ceasuri.getDetalii());
			preparedStatement.setString(11, ceasuri.getImg());
			
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException  | NullPointerException e) {
			System.out.println("nu s-au putut introduce datele");
			e.printStackTrace();
			return false;
		} finally {
			inchideResursele();
		}
	}
	//List<Ceas>genCeas=afiseazaCeasuri();
	
	public List<Ceas> showCeas(){
		return afiseazaCeasuri();
	}

	public static Ceas getCeas(String idString) {
		int id = Integer.parseInt(idString);
		return afiseazaCeasuri().get(id-1);
	}

	public static Ceas golesteCos(String idString){
		int id = Integer.parseInt(idString);
		return afiseazaCeasuri().get(id-1);
	}
	
	// Preia useri
		public static HashMap<String, String> getUseri() {
			creazaConexiunea();
			try {
				statement = con.createStatement();
				String sql = "SELECT * FROM user";
				resultSet = statement.executeQuery(sql);

				HashMap<String, String> mapUseri = new HashMap<String, String>();

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nume_prenume = resultSet.getString("nume_prenume");
					String email = resultSet.getString("email");
					String parola = resultSet.getString("parola");
					String telefon = resultSet.getString("telefon");

					mapUseri.put(email, parola);
				}
				return mapUseri;

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Nu s-a efectuat interogarea");
				return null;
			} finally {
				inchideResursele();
			}
		}
	
}






