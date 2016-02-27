package hostel.services;

import hostel.db.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/users")
public class Users {
	
	@POST
	@Path("/login")
	@Consumes("application/x-www-form-urlencoded")
	public Response login(@Context HttpServletRequest request,@Context HttpServletResponse response, @FormParam("username")String userName, @FormParam("password")String password){
		Response result = null;
		try{
			boolean isValidUser = isValidUser(userName,password);
			if(isValidUser){
				result = Response.ok().build();
				//response.sendRedirect("www.google.com");
			}
			else
				result = Response.status(403).build();
		}catch(Exception e){
			e.printStackTrace();
			result = Response.status(500).build();
		}
		return result;
	}

	private boolean isValidUser(String userName, String password) throws SQLException {
		boolean isValidUser = false;
		try{
			String query = "select count(*) from users where userid ='admin' and password='admin'";
			ResultSet result = DBUtil.executeSelectQuery(query);
			if(result.next()){
				//atleast one guy is there
				isValidUser = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isValidUser;
	}
	
	
}
