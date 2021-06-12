package br.com.fiap.rest;

import br.com.fiap.dao.RegisterDAO;
import br.com.fiap.model.Register;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("registers")
@Produces(MediaType.APPLICATION_JSON)
public class RegisterEndpoint {

	private RegisterDAO dao = new RegisterDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Register> index() {
		return dao.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Register register) {
		if (register == null) {
			return Response.status(
					Response.Status.BAD_REQUEST).build();
		}
		try {
			dao.save(register);
		} catch (Exception e) {
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(
				Response.Status.CREATED).entity(register).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") Long id) {
		Register register = dao.findById(id);
		if (register == null) {
			return Response.status(
					Response.Status.BAD_REQUEST).build();
		}
		return Response.status(Response.Status.OK).entity(register).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Register register) {

		if (dao.findById(id) == null) {
			return Response.status(
					Response.Status.BAD_REQUEST).build();
		}
		if (register == null) {
			return Response.status(
					Response.Status.BAD_REQUEST).build();
		}
		register.setId(id);
		dao.update(register);


		return Response.status(Response.Status.OK).entity(register).build();

	}
}
