package de.thallys.resource;

import de.thallys.dto.FrutaDTO;
import de.thallys.service.FrutaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/fruta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutaResource {

    @Inject
    FrutaService frutaService;

    @GET
    @Transactional
    public Response findAll() {
        return frutaService.getAll();
    }

    @GET
    @Path("{id}")
    @Transactional
    public Response findById(@PathParam("id") Long id) {
        return frutaService.getById(id);
    }

    @POST
    @Transactional
    public Response createFruta(FrutaDTO dto) {
        return frutaService.createFruta(dto);
    }

    @PUT
    @Transactional
    public Response updateFruta(FrutaDTO dto) {
        return frutaService.updateFruta(dto);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        return frutaService.deleteById(id);
    }

}