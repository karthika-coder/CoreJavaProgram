package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Student
{

	String StuName;
	
	String DOB;
	
	Scanner sc = new Scanner(System.in);
	
	void insertRecord() throws ClassNotFoundException
	{
		try
		{
			System.out.println("Enter Student Name : ");
			StuName=sc.next();
			System.out.println("Enter Date Of Birth : ");
			DOB=sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into student values(?,?)");
			stmt.setString(1, StuName);
			stmt.setString(2, DOB);
			int i = stmt.executeUpdate();
			System.out.println(i+" Student record inserted");
			System.out.println("");
			con.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	void RetriveRecord() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Student Name: "+rs.getString(1));
				System.out.println("Date of Birth: "+rs.getString(2));
                System.out.println("");
			}
			
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		Student sql = new Student();
		sql.insertRecord();
		sql.RetriveRecord();
		
	}


}
