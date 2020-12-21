/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controller.ProcessoController;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Model.Processo;

/**
 *
 * @author Thiago Mathias Simon
 */
@Path("/processo")
public class ProcessoService {

    static ProcessoController Controller = new ProcessoController();

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Processo> getProcesso() {
        return Controller.getProcesso();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_processo}")
    public Response findProcessoJson(@PathParam("id_processo") int id_processo) {
        try {
            return Response.ok((Object) Controller.getProcesso(id_processo)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("")
    public Response saveJson(Processo obj) {
        try {
            System.out.println(obj.toString());
            obj.setId_processo(Controller.getProcesso().size() + 1);
            Controller.addProcesso(obj);

            return Response.ok((Object) obj).build();
        } catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id_processo}")
    public Response saveJsonPut(@PathParam("id_processo") int id_processo, Processo obj) {
        try {
            System.out.println(obj.toString());
            if (Controller.update(id_processo, obj)) {
                return Response.ok((Object) obj).build();
            } else {
                return Response.ok((Object) "Registro não encontradao.").build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_processo}")
    public Response delete(@PathParam("id_processo") int id_processo) {
        try {
            if (Controller.delete(id_processo)) {
                return Response.ok().build();
            } else {
                return Response.ok((Object) "Registro não encontradao.").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // return 404 to allow load balancers to only send traffic to the coordinator
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
