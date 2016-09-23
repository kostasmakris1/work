package gamesys.hr.raffle.exceptions;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Component
public class PlayerNotFoundExceptionMapper implements ExceptionMapper<PlayerNotFoundException> {
    @Override
    public Response toResponse(PlayerNotFoundException e) {
        return Response.status(HttpStatus.SC_NOT_FOUND).entity(new ExceptionResource(e.getMessage())).build();
    }
}
