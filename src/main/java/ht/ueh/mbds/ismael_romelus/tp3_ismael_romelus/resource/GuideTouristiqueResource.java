package ht.ueh.mbds.ismael_romelus.tp3_ismael_romelus.resource;

import ht.ueh.mbds.ismael_romelus.tp3_ismael_romelus.llm.LlmClientForGuideTouristique;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/guide")
public class GuideTouristiqueResource {
    @Inject
    private LlmClientForGuideTouristique llmClient;
    /**
     * Retourne les informations touristiques d'une ville ou d'un pays au format JSON.
     *
     * @param lieu le nom de la ville ou du pays
     * @return document JSON avec les endroits à visiter et le prix moyen d'un repas
     */
    @GET
    @Path("lieu/{lieu}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(@PathParam("lieu") String lieu,
    @QueryParam("nb") @DefaultValue("2") int nb){
        String question = "Donne-moi les " + nb + " principaux endroits à visiter à " + lieu;
        return llmClient.donnerInfos(question);
    }
}
