package com.example.autonuoma.rest;

import com.example.autonuoma.entities.Automobilis;
import com.example.autonuoma.persistence.MasinosDAO;
import com.example.autonuoma.rest.contracts.AutomobiliaiDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/auto")
public class Controller {
    @Inject
    @Setter
    @Getter
    private MasinosDAO masinosDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Automobilis automobilis = masinosDAO.findOne(id);

        if (automobilis == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        AutomobiliaiDto autoDto = new AutomobiliaiDto();
        autoDto.setId(automobilis.getId());
        autoDto.setMarke(automobilis.getMarke());
        autoDto.setModelis(automobilis.getModelis());
        autoDto.setVin(automobilis.getVin());

        return Response.ok(autoDto).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(AutomobiliaiDto automobiliaiDto)
    {
        try{
            Automobilis automobilis = new Automobilis();
            automobilis.setMarke(automobiliaiDto.getMarke());
            automobilis.setModelis(automobiliaiDto.getModelis());
            automobilis.setVin(automobiliaiDto.getVin());

            masinosDAO.persist(automobilis);

            return Response.status(Response.Status.CREATED).build();
        }
        catch (OptimisticLockException ex) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Long autoId,
                           AutomobiliaiDto automobiliaiDto)
    {
        try {
            Automobilis automobilis = masinosDAO.findOne(autoId);
            if (automobilis == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            automobilis.setMarke(automobiliaiDto.getMarke());
            automobilis.setModelis(automobiliaiDto.getModelis());
            automobilis.setVin(automobiliaiDto.getVin());

            masinosDAO.update(automobilis);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
