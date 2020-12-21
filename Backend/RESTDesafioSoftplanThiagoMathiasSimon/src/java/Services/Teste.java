/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Thiago Mathias Simon
 */
/**
@Path: identifica o caminho do URI para o qual 
uma classe de recurso ou método de classe atenderá solicitações.
 */
@Path("/teste")
public class Teste {
        
        @GET
        @Produces (MediaType.TEXT_PLAIN)
        public String primeiro()
        {
            return "Testando webservice REST!!!";
        }
        
        
        @POST
        @Produces (MediaType.TEXT_PLAIN)
        public Response segundo(int rafa){
            System.out.println(rafa);
     
            return Response.ok((Object)"ok").build();
         }

}
