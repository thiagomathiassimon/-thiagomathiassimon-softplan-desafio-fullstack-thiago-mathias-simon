package Services;

import Controller.UsuarioController;
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
import Model.Usuario;

/**
 *
 * @author Thiago Mathias Simon
 *
 */
@Path("/usuario")
public class UsuarioService {

    static UsuarioController Controller = new UsuarioController();

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios() {
        return Controller.getUsuario();
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_usuario}")
    public Response findUsuarioJson(@PathParam("id_usuario") int id_usuario) {
        try {
            return Response.ok((Object) Controller.getUsuario(id_usuario)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("")
    public Response saveJson(Usuario obj) {
        try {
            System.out.println(obj.toString());
            obj.setId_usuario(Controller.getUsuario().size() + 1);
            Controller.addUsuario(obj);

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
    @Path("/{id_usuario}")
    public Response saveJsonPut(@PathParam("id_usuario") int id_usuario, Usuario obj) {
        try {
            System.out.println(obj.toString());
            if (Controller.update(id_usuario, obj)) {
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
    @Path("/{id_usuario}")
    public Response delete(@PathParam("id_usuario") int id_usuario) {
        try {
            if (Controller.delete(id_usuario)) {
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
