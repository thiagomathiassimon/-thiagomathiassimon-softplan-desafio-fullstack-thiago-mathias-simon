package Services;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Model.Credentials;
import Model.UserLogged;
import static Services.UsuarioService.Controller;
import Util.JWTUtil;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginService {

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    @POST
    @Path("/login")
    public Response login(Credentials credentials) {
                  
        if (Controller.acessoUsuario(credentials.getEmail(), credentials.getSenha())) {
            String token = JWTUtil.create(credentials.getEmail());
            UserLogged me = new UserLogged();
            me.setEmail(credentials.getEmail());
            me.setToken(token);
            return Response.ok().entity(me).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
