package com.rest.RestAPI;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.rest.dto.Employee;
import com.rest.dto.User;
import com.ts.dao.EmployeeDAO;
import com.ts.dao.UserDAO;


@Path("myresource")
public class MyResource {
	@Path("hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() throws UnsupportedEncodingException {
		System.out.println("Hi...");
		return "Hi Service!";
	}

/*	@Path("mail")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() throws MessagingException {

		String subject="Test Mail";
		String body="Java mail test...";
		String email="likithamanne99@gmail.com";
		String host = "smtp.gmail.com";
		String from = "mdgp2u@gmail.com";
		String pass = "abc1234";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ ) 
		{ 
			// changed from a while loop
			toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{ 
			// changed from a while loop
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();

		return "Successful";
	}
*/
    
	@Path("getUserByEmail/{email}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByEmail(@PathParam("email") String email) {
		System.out.println("Recieved path params: "+email); 
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByEmail(email);
		return user;
	}

	@Path("getUserByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getUserByUserPass(@PathParam("loginId") String loginId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+loginId+" "+password); 
		UserDAO userDAO = new UserDAO();
		Object user = userDAO.getUserByUserPass(loginId, password);
		System.out.println("my resource" + user);
		return user;
	}


	@Path("getUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {

		UserDAO userDAO = new UserDAO();
		List <User> userList = userDAO.getAllUsers();
		return userList;
	}
	
	@Path("registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(User user) {
		System.out.println("Data Recieved in Emp Register : " + user);
		UserDAO userDAO = new UserDAO();
		userDAO.register(user);
	}
	/*
	//It is sample code if need to test and insert values into any tables
	@Path("registerUser")
	@GET
	public void registerUser() {
		User user = new User();
		user.setFirstName("Sanjana");
		user.setLastName("Addanki");
		user.setEmail("sanjana@gmail.com");
		user.setLoginId("sanjana_addanki");
		user.setMobileNo("7277637873");
		user.setPassword("sanjana");
		UserDAO userDAO = new UserDAO();
		userDAO.register(user);
	}*/
}
