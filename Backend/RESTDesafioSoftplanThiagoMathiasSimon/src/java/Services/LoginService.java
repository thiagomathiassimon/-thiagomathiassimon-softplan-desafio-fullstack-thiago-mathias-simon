package Services;

import DAO.UsuarioDAO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;
import static javax.management.Query.times;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Model.Credentials;
import Model.UserLogged;
import Model.Usuario;
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
            //  if(this.EMAIL.equals(credentials.getEmail()) && this.SENHA.equals(credentials.getSenha())){ 
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
