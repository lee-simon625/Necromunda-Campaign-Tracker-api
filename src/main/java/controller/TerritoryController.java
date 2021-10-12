package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.j256.ormlite.stmt.query.In;
import data.MySQLService;
import data.dao.TerritoryDao;
import objects.Campaign;
import objects.territories.Territory;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.ArrayList;

public class TerritoryController {

    private TerritoryDao territoryDao;

    public TerritoryController(MySQLService service) {
        this.territoryDao = new TerritoryDao(service);
    }

    public String getTerritories(Request req, Response res) throws JsonProcessingException {
        ArrayList<Territory> territories = new ArrayList<>();
        try {
            territories = this.territoryDao.list(Integer.parseInt(req.params(":id")));
            System.out.println("id: " + req.params(":id"));
            System.out.println(territories);

        } catch (Exception e) {
            System.out.println(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(territories);

        return jsonStr;
    }

    public String getOwnedTerritories(Request req, Response res) throws JsonProcessingException {
        ArrayList<Territory> territories = new ArrayList<>();
        try {
            territories = this.territoryDao.listOwned(Integer.parseInt(req.params(":gangId")));
            System.out.println("gangId: " + req.params(":gangId"));
            System.out.println(territories);

        } catch (Exception e) {
            System.out.println(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(territories);

        return jsonStr;
    }

    public Integer postTerritory(Request req, Response res) {

        res.type("application/json");
        Territory territory = new Gson().fromJson(req.body(), Territory.class);
        System.out.println("Json converted into campaign");

        try {
            Integer newId = this.territoryDao.create(territory);
            res.body(String.valueOf(newId));

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public String putTerritory(Request req, Response res) {
        res.type("application/json");
        Territory territory = new Gson().fromJson(req.body(), Territory.class);
        System.out.println("Json converted into Territory");

        try {
            Integer newId = this.territoryDao.update(territory);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Integer deleteTerritory(Request req, Response res) {
        try {
            this.territoryDao.delete(Integer.parseInt(req.params(":id")));
            return Integer.parseInt(req.params(":id"));
        } catch (SQLException e) {
            return null;
        }

    }


}
