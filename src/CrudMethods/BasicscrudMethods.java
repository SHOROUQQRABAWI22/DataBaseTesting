package CrudMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Statement;

public class BasicscrudMethods {

	  Connection con=null;
	java.sql.Statement stm=null;
	  ResultSet rs;
	@BeforeTest
	public void pre_test() throws SQLException
	{
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Ali123456ali");
	}

	@Test(priority=1)
	public void AddNewData() throws SQLException

{
		stm=con.createStatement();
	String myQuery = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) "
				+ "VALUES (5586, 'Mohammad Ahmad', 'ali', 'Mohammad', 079778882, 'Tlaaalali', 'Amman', 'Jordan')";
int insertRow=stm.executeUpdate(myQuery);

	if(	insertRow>0)
	{
		
		System.out.println("query is done");

	}
	else
	{
		System.out.println("query is failed");

	}

		
		}
	@Test(priority=2)
	public void UpdateData() throws SQLException

{
		stm=con.createStatement();
		
		String myQuery = "UPDATE customers SET customerName = 'shosho aqrabawi' WHERE customerNumber = 5586";

		int updatrow = stm.executeUpdate(myQuery);
		
		if(	updatrow>0)
		{
			
			System.out.println("yes");

		}
		else
		{
			System.out.println("no");

		}
		Assert.assertEquals(updatrow > 0, true, "sorry the update has a problem");
		
}
	@Test(priority=3)
	public void SelectOneCustomr() throws SQLException

{
		stm=con.createStatement();
	rs=	stm.executeQuery("select * from customers where customerNumber=5586");
	while(	rs.next())
	{
		
		String custom=rs.getString("customerName");
		System.out.println(custom);
	
		Assert.assertEquals(custom, "shosho aqrabawi");

	}

	
		}
	@Test(priority=4)
	public void DeletRow() throws SQLException

{
		stm=con.createStatement();
		
		
		String delet="delete from customers where customerName='shosho aqrabawi' and customerNumber = 5586";
		int Deletrow= stm.executeUpdate(delet);
		if(	Deletrow>0)
		{
			
			System.out.println("yes delet");

		}
		else
		{
			System.out.println("no");

		}
		Assert.assertEquals(Deletrow > 0, true, "sorry the delete has a problem");
}
		
	@AfterTest
	public void post_test()
	{
		
	}
}

