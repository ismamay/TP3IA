package ht.ueh.mbds.ismael_romelus.tp3_ismael_romelus.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Retourne les informations touristiques d'une ville ou d'un pays au format JSON.
     *
     * @param lieu le nom de la ville ou du pays
     * @return document JSON avec les endroits à visiter et le prix moyen d'un repas
     */
    @GET
    @Path("lieu/{lieu}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] endroitsDeVisite(@PathParam("lieu") String lieu) {
        return new String[]{lieu};
    }
}
