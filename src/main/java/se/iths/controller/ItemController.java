package se.iths.controller;

import se.iths.entity.Item;
import se.iths.service.ItemService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemController {

    @Inject
    private ItemService itemService;

    @Path("")
    @GET
    public Response getAllItem() {
        List<Item> findAll = itemService.findAllItem();
        return Response.ok(findAll).build();
    }

    @Path("")
    @POST
    public Response createItem(Item item) {
        itemService.createItem(item);

        return Response.ok(item).build();
    }

    @Path("/update")
    @PUT
    public Response updateItem(Item item) {
        itemService.updateItem(item);
        return Response.ok().build();
    }

    @Path("{id}")
    @GET
    public Response findItemById(@PathParam("id") Long id) {
        return Response.ok(itemService.findItemById(id)).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteItemById(@PathParam("id") Long id) {
        itemService.deleteItem(id);
        return Response.ok().build();
    }


}
