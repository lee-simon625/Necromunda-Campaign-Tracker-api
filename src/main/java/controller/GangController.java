package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.google.gson.Gson;
import data.MySQLService;
import data.dao.GangDao;
import objects.gangs.Gang;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.ArrayList;

public class GangController {

    private GangDao gangDao;


    public GangController(MySQLService service) {
        this.gangDao = new GangDao(service);
    }

    public String getGangs(Request req, Response res) throws JsonProcessingException {
        ArrayList<Gang> gangs = new ArrayList<>();
        try {
            gangs = this.gangDao.list(Integer.parseInt(req.params(":id")));
            System.out.println("id: " + req.params(":id"));
            System.out.println(gangs);

        } catch (Exception e) {
            System.out.println(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String gangsString = objectMapper.writeValueAsString(gangs);

        return gangsString;
    }

    public Integer postGang(Request req, Response res) {
        res.type("application/json");
        Gang gang = new Gson().fromJson(req.body(), Gang.class);
        System.out.println("Json converted into Gang");

        try {
            Integer newId = this.gangDao.create(gang);
            res.body(String.valueOf(newId));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String putGang(Request req, Response res) {
        res.type("application/json");
        Gang gang = new Gson().fromJson(req.body(), Gang.class);
        System.out.println("Json converted into Gang");

        try {
            Integer newId = this.gangDao.update(gang);
            res.body(String.valueOf(newId));

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Integer deleteGang(Request req, Response res) {
        try {
            this.gangDao.delete(Integer.parseInt(req.params(":id")));
            res.body(String.valueOf(Integer.parseInt(req.params(":id"))));
            return Integer.parseInt(req.params(":id"));
        } catch (SQLException e) {
            return null;
        }
    }
}
