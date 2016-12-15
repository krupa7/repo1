package com.nuvizz.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvizz.rest.dto.PersonDTO;
import com.nuvizz.rest.service.PersonServiceImpl;


@Component
@Path("/rest")
public class RestResource {

	public RestResource() {
		System.out.println(this.getClass().getSimpleName() + " Created!!");
	}

	@Autowired
	private PersonServiceImpl impl;

	
	
	@GET
	@Path("/hello")
	public Response getMsg() {
		return Response.status(Status.OK).entity("Hello").build();

	}

	@GET
	@Path("/getname/{name}")
	public Response getName(@PathParam("name") String nm) {
		String str = "Name=" + nm;
		System.out.println(str);
		return Response.status(Status.OK).entity(str).build();

	}

	@POST
	@Path("/getdetails/{acc}/{balance}")
	public Response getName(@PathParam("acc") String nm,
			@PathParam("balance") String bal) {
		String str = "Account=" + nm + "\t" + "balance=" + bal;
		System.out.println(str);
		return Response.status(Status.OK).entity(str).build();

	}

	@POST
	@Path("/getperson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPerson(PersonDTO personDTO) {
		System.out.println("name=" + personDTO.getName() + "\t" + "email="
				+ personDTO.getEmail());
		return Response.status(Status.OK).entity("Success").build();

	}

	@POST
	@Path("/saveperson")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Response savePerson(PersonDTO dto) {
		System.out.println(dto);
		boolean res = impl.savepersonservice(dto);
		if (res)
			return Response.status(Status.OK).entity("Success").build();
		else
			return Response.status(Status.OK).entity("Fail").build();

	}
	
	@GET
	@Path("/fetch")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchall() {
		List<PersonDTO> list=impl.fetchallService();
		for (PersonDTO personDTO : list) {
			System.out.println(personDTO);
		}
		if (list!=null)
			return Response.status(Status.OK).entity(list).build();
		else
			return Response.status(Status.OK).entity("Fail").build();

	}

}
