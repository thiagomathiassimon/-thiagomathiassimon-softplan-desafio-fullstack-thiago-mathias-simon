package Services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Thiago Mathias Simon
 */

/**
   * @ApplicationPath: esta anotação identifica o caminho do aplicativo que serve como 
   * URI de base para todos os recursos. Isso deve ser usado na classe de configuração, 
   * ou seja, a subclasse de javax.ws.rs.core.Application. 
**/

@ApplicationPath("/api")
public class RestApplicationPath extends Application{
    
}
