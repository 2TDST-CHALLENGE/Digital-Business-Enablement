package br.com.fiap.rest;

import br.com.fiap.dao.RegisterDAO;
import br.com.fiap.model.Register;
import br.com.fiap.model.Setup;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("setups")
@Produces(MediaType.APPLICATION_JSON)
public class SetupEndpoint {
	
	RegisterDAO dao = new RegisterDAO();
	
	@GET
	public List<Register> index() {
		return dao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Register setup) {
		if (setup == null) {
			return Response
					.status(Response.Status.BAD_REQUEST)
					.build();
		}
		try {
			dao.save(setup);
		} catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
		return Response
				.status(Response.Status.CREATED)
				.entity(setup)
				.build();
	}
	
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") Long id) {
		Register setup = dao.findById(id);
		if (setup == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();

		}
		return Response
					.status(Response.Status.OK)
					.entity(setup)
					.build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Setup setup ) {
		setup.setId(id);
		dao.update(setup);
		return Response
				.status(Response.Status.OK)
				.entity(setup)
				.build();
	}
	
	
	
	
	
	
	
	

}
