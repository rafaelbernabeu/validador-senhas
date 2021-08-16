package resource;

import service.ValidaSenhaService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/senhas")
public class ValidaSenhaResource {

    @Inject
    ValidaSenhaService validaSenhaService;

    @POST
    @Path("/validar")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean validar(String senha) {
        return validaSenhaService.isSenhaValida(senha);
    }
}