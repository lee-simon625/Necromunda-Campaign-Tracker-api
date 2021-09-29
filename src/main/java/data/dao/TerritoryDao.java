package data.dao;

import com.j256.ormlite.stmt.query.In;
import data.MySQLService;
import data.mappers.TerritoryMapper;
import objects.territories.Territory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TerritoryDao {

    private MySQLService service;

    public TerritoryDao(MySQLService service) {
        this.service = service;
    }

    public ArrayList<Territory> list(Integer id) throws SQLException {
        try {
            String stmt = "SELECT " +
                    "territories.id, " +
                    "territories.is_default, " +
                    "base_territories.name, " +
                    "base_territories.income, " +
                    "base_territories.recruit, " +
                    "base_territories.equipment, " +
                    "base_territories.special, " +
                    "base_territories.reputation, " +
                    "base_territories.gang_income, " +
                    "base_territories.gang_recruit, " +
                    "base_territories.gang_equipment, " +
                    "base_territories.gang_special, " +
                    "base_territories.gang_reputation " +
                    "FROM territories " +
                    "LEFT JOIN base_territories ON territories.territory_id = base_territories.id " +
                    "WHERE territories.campaign_id= ? " +
                    "ORDER BY base_territories.name;";

            PreparedStatement preparedStatement = service.createStatement(stmt);
            preparedStatement.setInt(1, id);

            ResultSet rs = this.service.get(preparedStatement);

            ArrayList<Territory> territories = new ArrayList<>();
            TerritoryMapper mapper = new TerritoryMapper();

            while (rs.next()) {

                territories.add(mapper.map(rs));
            }
            return territories;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Territory> listOwned(int gangID) throws SQLException {
        try {
            String stmt = "SELECT " +
                    "territories_inplay.gang_id, " +
                    "territories_inplay.territory_id, " +
                    "territories.name, territories.income, " +
                    "territories.recruit, territories.equipment, " +
                    "territories.special, territories.reputation, " +
                    "territories.gang_income, territories.gang_recruit, " +
                    "territories.gang_equipment, territories.gang_special, " +
                    "territories.gang_reputation" +
                    "FROM territories_inplay" +
                    "INNER JOIN territories ON territories_inplay.territory_id=territories.id" +
                    "left JOIN gangs ON territories_inplay.gang_id= gangs.id" +
                    "WHERE gangs.id = ?" +
                    "ORDER BY gangs.player, territories.name;";

            PreparedStatement preparedStatement = service.createStatement(stmt);
            preparedStatement.setInt(1, gangID);

            ResultSet rs = this.service.get(preparedStatement);

            ArrayList<Territory> territories = new ArrayList<>();
            TerritoryMapper mapper = new TerritoryMapper();

            while (rs.next()) {
                territories.add(mapper.map(rs));
            }
            return territories;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Territory> listBase() throws SQLException {
        try {
            String stmt = "SELECT * FROM territories";

            PreparedStatement preparedStatement = service.createStatement(stmt);

            ResultSet rs = this.service.get(preparedStatement);

            ArrayList<Territory> territories = new ArrayList<>();
            TerritoryMapper mapper = new TerritoryMapper();

            while (rs.next()) {
                territories.add(mapper.map(rs));
            }
            return territories;


        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public Integer create(Territory territory) throws SQLException {

        try {
            String stmt = (territory.getGangID() == null) ?
                    "INSERT INTO territories(campaign_id, territory_id) VALUES (?,?);" :
                    "INSERT INTO territories(campaign_id, territory_id, gang_id) VALUES (?,?,?);";

            PreparedStatement preparedStatement = service.createStatement(stmt, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, territory.getCampaignID());
            preparedStatement.setInt(2, territory.getBaseTerritoryID());

            if (territory.getGangID() != null) {
                preparedStatement.setInt(3, territory.getGangID());
            }

            Integer newID = this.service.create(preparedStatement);

            System.out.println("Created Territory with ID: " + newID);

            return newID;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}
