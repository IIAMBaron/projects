import java.util.Scanner;
import java.sql.*;

public class CreatingDatabase {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// initializing variables.
		int port = 64936;
		String connectionURL = "jdbc:sqlserver://localhost:" + port + ";database=BasicJavaPro;integratedSecurity=true;encrypt=false";
		String patientName;
		String patientSurname;
		String idNumTemp;
		String cellNumTemp;
		int idNum = 0;
		int cellNum = 0;
		String studNum = "1";
		
		/*java -cp "C:\Program Files (x86)\Java\jre-1.8\lib\ext\mssql-jdbc-12.4.1.jre11.jar" CreatingDatabase.java */
		
		while (true) {
				
			// This will ask the user to input data.
			System.out.println("Welcome to Eduvos Clinic App");
			System.out.print("Enter Patient name: ");
			patientName = scan.nextLine();
			System.out.print("Enter Patient surname: ");
			patientSurname = scan.nextLine();
			System.out.print("Enter ID Number: ");
			idNumTemp = scan.nextLine();
			System.out.print("Enter Cell Number: ");
			cellNumTemp = scan.nextLine();
			System.out.print("Enter Student Number: ");
			studNum = scan.nextLine();

			/* These are to catch whether or not ID number is and int and the same 
			applies to cell number. */
			try {
				idNum = Integer.parseInt(idNumTemp);
				cellNum = Integer.parseInt(cellNumTemp);
			} catch (Exception x) {
				System.out.println("Enter Numbers for ID or Cell Number");
				System.out.println();
				continue;
			}
			
			if (studNum.equals("0")) {
				break;
			}
			
			try {
			
				// Creating connection between Java and SQL Server using JDBC
				Connection con = DriverManager.getConnection(connectionURL);
				System.out.println("Connected to the database Eduvos Clinic");
				Statement stmt = con.createStatement();
		
				// Insertion of data into the table named "patients".
				String insertSql = "INSERT INTO patients VALUES (" + "'" + patientName + "'" + "," + "'" + patientSurname + "'" + "," + idNum + "," + cellNum + "," + "'" + studNum + "'" + ")";
				PreparedStatement prepsInsertData = con.prepareStatement(insertSql);
				prepsInsertData.execute();
				System.out.println("Patient information has been added to the database"); 
				System.out.println();
			
			} catch (SQLException y) {
			y.printStackTrace();
			}
			
		}
		System.out.println("Thank you for using the Eduvos Clinic App. Good Bye!");
	}
}