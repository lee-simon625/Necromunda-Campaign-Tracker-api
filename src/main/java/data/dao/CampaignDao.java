package data.dao;

import data.MySQLService;
import data.mappers.CampaignMapper;
import objects.Campaign;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CampaignDao {

    private MySQLService service;


    public CampaignDao(MySQLService service) {
        this.service = service;
    }

    public ArrayList<Campaign> list() throws SQLException {
        try {
            String stmt = "SELECT * From campaign;";

            ResultSet rs = this.service.get(service.createStatement(stmt));

            ArrayList<Campaign> campaigns = new ArrayList<>();
            CampaignMapper mapper = new CampaignMapper();

            while (rs.next()) {
                campaigns.add(mapper.map(rs));
            }
            return campaigns;

        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }


    public Campaign get(Integer id) throws SQLException {
        try {
            String stmt = "SELECT * From campaign where id = ? ;";

            PreparedStatement preparedStatement = service.createStatement(stmt);
            preparedStatement.setInt(1, id);

            ResultSet rs = this.service.get(preparedStatement);

            CampaignMapper mapper = new CampaignMapper();
            Campaign campaign = mapper.map(rs);

            return campaign;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer create(Campaign campaign) throws SQLException {
        try {
            String stmt = "INSERT INTO campaign(name, notes, password) VALUES (?,?,?);";

            PreparedStatement preparedStatement = service.createStatement(stmt, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, campaign.getName());
            preparedStatement.setString(2, campaign.getNotes());
            preparedStatement.setString(3, campaign.getPassword());
            Integer newID = this.service.create(preparedStatement);
            System.out.println("Created Campaign with ID:" + newID);

            return newID;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer update(Campaign campaign) throws SQLException {
        try {
            String stmt = "UPDATE campaign" +
                    "SET name = ?, notes = ?, password = ?" +
                    "WHERE id = ?;";

            PreparedStatement preparedStatement = service.createStatement(stmt);

            preparedStatement.setString(1, campaign.getName());
            preparedStatement.setString(2, campaign.getNotes());
            preparedStatement.setString(3, campaign.getPassword());
            preparedStatement.setInt(4, campaign.getId());
            this.service.update(preparedStatement);
            System.out.println("Updated Campaign with ID:" + campaign.getId());

            return campaign.getId();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Integer delete(Integer id) throws SQLException {
        try {
            String stmt = "DELETE FROM campaign" +
                    "WHERE id = ?";

            PreparedStatement preparedStatement = service.createStatement(stmt);

            preparedStatement.setInt(1, id);

            this.service.delete(preparedStatement);


            return id;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }



}
