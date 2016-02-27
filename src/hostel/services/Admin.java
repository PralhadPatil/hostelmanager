package hostel.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("admin")
public class Admin {
	@Path("addUser")
	@POST
	public Response addUser(@Context HttpServletRequest request, @Context HttpServletResponse response){
		Response reply = null;
		return reply;
	}
	
	@Path("removeUser")
	@POST
	public Response removeUser(@Context HttpServletRequest request, @Context HttpServletResponse response){
		Response reply = null;
		return reply;
	}
	
	@Path("editUser")
	@POST
	public Response editUser(@Context HttpServletRequest request, @Context HttpServletResponse response){
		Response reply = null;
		return reply;
	}
	
}
