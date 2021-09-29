package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import data.MySQLService;
import data.dao.CampaignDao;
import objects.Campaign;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

public class CampaignController {

    private CampaignDao campaignDao;

    public CampaignController(MySQLService service) {
        this.campaignDao = new CampaignDao(service);
    }

    public String getCampaigns(Request req, Response res) throws JsonProcessingException {
        String jsonStr = "";

        try {
            ArrayList<Campaign> campaigns = this.campaignDao.list();
            System.out.println("id: " + req.params(":id"));
            System.out.println(campaigns);
            ObjectMapper objectMapper = new ObjectMapper();
            jsonStr = objectMapper.writeValueAsString(campaigns);
        } catch (Exception e) {
            System.out.println(e);
        }

        return jsonStr;
    }


    public String getCampaign(Request req, Response res) throws JsonProcessingException {
        String jsonStr = "";
        try {
            Campaign campaign = this.campaignDao.get(Integer.parseInt(req.params(":id")));
            System.out.println("id: " + req.params(":id"));
            System.out.println(campaign);
            ObjectMapper objectMapper = new ObjectMapper();
            jsonStr = objectMapper.writeValueAsString(campaign);

        } catch (Exception e) {
            System.out.println(e);
        }

        return jsonStr;
    }

    public Integer postCampaign(Request req, Response res) {

        res.type("application/json");
        Campaign campaign = new Gson().fromJson(req.body(), Campaign.class);
        System.out.println("Json converted into campaign");

        try {
            Integer newId = this.campaignDao.create(campaign);
            res.body(String.valueOf(newId));

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Integer putCampaign(Request req, Response res) {
        res.type("application/json");
        Campaign campaign = new Gson().fromJson(req.body(), Campaign.class);
        System.out.println("Json converted into campaign");

        try {
            Integer newId = this.campaignDao.update(campaign);
            res.body(String.valueOf(newId));

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Integer deleteCampaign(Request req, Response res) {
        return null;
    }




}
