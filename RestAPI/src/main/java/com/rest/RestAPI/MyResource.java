package com.rest.RestAPI;

import java.io.IOException;
import java.io.InputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import com.rest.dto.ItemDetails;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.rest.dto.ToDoTask;
import com.rest.dto.User;
import com.ts.dao.ToDoTasksDAO;
import com.ts.dao.UserDAO;
import com.ts.dao.ItemDAO;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import javax.ws.rs.PUT;
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
	@Path("getUserById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") Integer id) {
		System.out.println("Recieved path params: "+id); 
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUser(id);
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

	@Path("getTasks/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ToDoTask> getTasks(@PathParam("userId") Integer userId) {
		ToDoTasksDAO tasksDAO = new ToDoTasksDAO();
		List <ToDoTask> taskList = tasksDAO.getAllTasks(userId);
		return taskList;
	}
	@Path("deleteTask/{taskId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteTasks(@PathParam("taskId") Integer taskId) {
		ToDoTasksDAO tasksDAO = new ToDoTasksDAO();
		tasksDAO.deleteTask(taskId);
	}
	
	@Path("registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(User user) {
		System.out.println("Data Recieved in Emp Register : " + user);
		UserDAO userDAO = new UserDAO();
		userDAO.register(user);
	}
	@Path("updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User user) {
		System.out.println("Data Recieved in user update : " + user);
		UserDAO userDAO = new UserDAO();
		userDAO.updateUser(user);
	}

	@Path("updateTask")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTask(ToDoTask task) {
		System.out.println("Data Recieved in task update : " + task);
		ToDoTasksDAO tasksDAO = new ToDoTasksDAO();
		tasksDAO.updateTask(task);
	}
	
	
	@Path("addTask")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void addTask(@FormDataParam("taskPlace") String taskPlace,
	@FormDataParam("taskDescription") String taskDescription,
	@FormDataParam("userId") Integer userId) throws IOException {; 
		User user = new User();
		user.setUserId(userId);
		System.out.println("Inside add Task");
		ToDoTask task = new ToDoTask();
		task.setTaskPlace(taskPlace);
		task.setTaskDescription(taskDescription);
		task.setUserDetails(user);
		ToDoTasksDAO tasksDAO = new ToDoTasksDAO();
		tasksDAO.add(task);
	}
	
	//It is sample code if need to test and insert values into any tables
	/*@Path("addTask")
	@GET
	public void addTask() {
		ToDoTask task = new ToDoTask();
		task.setTaskPlace("Amalapuram");
		task.setTaskDescription("Want to Visit Park" );
		ToDoTasksDAO tasksDAO = new ToDoTasksDAO();
		tasksDAO.add(task);
	}*/
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
	@Path("uploadImage")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadImage(@FormDataParam("itemImage") InputStream fileInputStream,
			@FormDataParam("itemImage") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("itemName") String itemName,
	@FormDataParam("itemDescription") String itemDescription,
	@FormDataParam("itemType") String itemType,
	@FormDataParam("userId") Integer userId) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[1024];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		User user = new User();
		user.setUserId(userId);
		System.out.println("Inside upload Image");
		ItemDetails item = new ItemDetails();
		item.setItemName(itemName);
		item.setItemDescription(itemDescription);
		item.setItemType(itemType);
		item.setItemImage(formDataContentDisposition.getFileName());
		item.setUserDetails(user);
		ItemDAO itemDao = new ItemDAO();
		itemDao.additem(item);
	}
	@Path("getTaskById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ToDoTask getTaskById(@PathParam("id") Integer id) {
		System.out.println("Recieved path params: " + id); 
		ToDoTasksDAO tasksDAO = new ToDoTasksDAO();
		ToDoTask task = tasksDAO.getTask(id);
		return task;
	}
	@Path("getItems")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemDetails> getItems() {

		ItemDAO itemDAO = new ItemDAO();
		List <ItemDetails> itemList = itemDAO.getAllItemDetails();

		return itemList;
	}
}
