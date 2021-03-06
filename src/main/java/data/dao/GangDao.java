package data.dao;

import data.MySQLService;
import data.mappers.GangMapper;
import objects.gangs.BaseGang;
import objects.gangs.Gang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GangDao {

    private MySQLService service;

    public GangDao(MySQLService service) {
        this.service = service;
    }

    public ArrayList<Gang> list(Integer campaignId) throws SQLException {
        try {
            String stmt = "SELECT " +
                    "gangs.id, " +
                    "gangs.campaign_id, " +
                    "gangs.player, " +
                    "gangs.gang_name, " +
                    "base_gangs.gang_type,  " +
                    "gangs.total_value, " +
                    "gangs.reputation, " +
                    "gangs.total_wins " +
                    "FROM gangs " +
                    "LEFT JOIN base_gangs ON gangs.gang_type = base_gangs.id " +
                    "WHERE gangs.campaign_id= ? ;";

            PreparedStatement preparedStatement = service.createStatement(stmt);
            preparedStatement.setInt(1, campaignId);

            ResultSet rs = this.service.get(preparedStatement);

            ArrayList<Gang> gangs = new ArrayList<>();
            GangMapper mapper = new GangMapper();

            while (rs.next()) {

                gangs.add(mapper.map(rs));
            }

            return gangs;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<BaseGang> listBase() throws SQLException {
        try {
            String stmt = "SELECT * FROM base_gangs";

            PreparedStatement preparedStatement = service.createStatement(stmt);

            ResultSet rs = this.service.get(preparedStatement);

            ArrayList<BaseGang> baseGangs = new ArrayList<>();
            GangMapper mapper = new GangMapper();
            while (rs.next()) {

                baseGangs.add(mapper.baseMap(rs));

            }
            return baseGangs;


        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public Integer create(Gang gang) {

        try {
            String stmt = "INSERT INTO gangs(campaign_id, player, gang_name, gang_type) VALUES (?,?,?,?,1000,1,0);";
            PreparedStatement preparedStatement = service.createStatement(stmt);
            preparedStatement.setInt(1, gang.getCampaignID());
            preparedStatement.setString(2, gang.getPlayer());
            preparedStatement.setString(3, gang.getName());
            preparedStatement.setInt(4, gang.getGangTypeID());

            Integer newID = this.service.create(preparedStatement);

            System.out.println("Created Gang with ID: " + newID);

            return newID;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Integer update(Gang gang) throws SQLException {
        try {
            String stmt = "UPDATE gang" +
                    "SET gangTypeID = ?, " +
                    "player = ?, " +
                    "name = ?, " +
                    "gangType = ?, " +
                    "totalValue = ?, " +
                    "reputation = ?, " +
                    "totalWins = ?" +
                    "WHERE id = ?;";

            PreparedStatement preparedStatement = service.createStatement(stmt);

            preparedStatement.setInt(1, gang.getGangTypeID());
            preparedStatement.setString(2, gang.getPlayer());
            preparedStatement.setString(3, gang.getName());
            preparedStatement.setString(4, gang.getGangType());
            preparedStatement.setInt(5, gang.getTotalValue());
            preparedStatement.setInt(6, gang.getReputation());
            preparedStatement.setInt(7, gang.getTotalWins());
            preparedStatement.setInt(8, gang.getId());


            this.service.update(preparedStatement);
            System.out.println("Updated Gang with ID: " + gang.getId());

            return gang.getId();

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public Integer delete(Integer id) throws SQLException {
        try {
            String stmt = "DELETE FROM gang" +
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
