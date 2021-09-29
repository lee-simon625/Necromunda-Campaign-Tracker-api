package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import data.MySQLService;
import data.dao.GangDao;
import objects.gangs.Gang;
import spark.Request;
import spark.Response;

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

        return null;
    }

    public String putGang(Request req, Response res) {

        return null;
    }
    public String deleteGang(Request req, Response res) {

        return null;
    }

}
