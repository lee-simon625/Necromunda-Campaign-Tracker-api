import com.google.gson.Gson;
import controller.CampaignController;
import controller.GangController;
import controller.TerritoryController;
import data.MySQLService;

import data.dao.TerritoryDao;
import objects.Campaign;
import spark.Filter;
import spark.Service;
import spark.Spark;

import static spark.Spark.*;


//https://86.12.177.19:4567/campaign


public class Main {
    public static void main(String[] args) {
        String keyStoreLocation = "deploy/keystore.jks";
        String keyStorePassword = "password";
        secure(keyStoreLocation, keyStorePassword, null, null);
        MySQLService service = new MySQLService();
        CampaignController campaignController = new CampaignController(service);
        TerritoryController territoryController = new TerritoryController(service);
        GangController gangController = new GangController(service);

        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Methods", "*");
        });

        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Headers", "*");
        });

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        try {

            //Campaign Paths
            get("/campaign", (req, res) -> campaignController.getCampaigns(req, res));

            get("/campaign/:id", (req, res) -> campaignController.getCampaign(req, res));

            post("/campaign/new", (req, res) -> campaignController.postCampaign(req, res));

            put("/campaign/:id/update", (req, res) -> campaignController.putCampaign(req, res));

            delete("/campaign/:id/delete", (req, res) -> campaignController.deleteCampaign(req, res));

            //----------------------------------------------------------------------------------------------
            //Gang Paths

            get("/campaign/:id/gang", (req, res) -> gangController.getGangs(req, res));

            post("/campaign/:id/gang/new", (req, res) -> gangController.postGang(req, res));

            put("/campaign/:id/gang/:gangId/update", (req, res) -> gangController.putGang(req, res));

            delete("/campaign/:id/gang/:gangId/delete", (req, res) -> gangController.deleteGang(req, res));

            //----------------------------------------------------------------------------------------------
            //Territory Paths

            get("/campaign/:id/territory", (req, res) -> territoryController.getTerritories(req, res));

            get("/campaign/:id/territory/:gangId", (req, res) -> territoryController.getOwnedTerritories(req, res));

            post("/campaign/:id/territory/new", (req, res) -> territoryController.postTerritory(req, res));

            put("/campaign/:id/territory/:territoryId/update", (req, res) -> territoryController.putTerritory(req, res));

            delete("/campaign/:id/territory/:territoryId/delete", (req, res) -> territoryController.deleteTerritory(req, res));

        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
