package data.mappers;

import objects.territories.Territory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TerritoryMapper {

    public Territory map(ResultSet rs) throws SQLException {

        return new Territory(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("income"),
                rs.getString("recruit"),
                rs.getString("equipment"),
                rs.getString("special"),
                rs.getInt("reputation"),
                rs.getString("gang_income"),
                rs.getString("gang_recruit"),
                rs.getString("gang_equipment"),
                rs.getString("gang_special"),
                rs.getInt("gang_reputation"));


    }
}
