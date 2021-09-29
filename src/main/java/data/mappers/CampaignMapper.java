package data.mappers;

import objects.Campaign;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CampaignMapper {

    public Campaign map(ResultSet rs) throws SQLException {
        return new Campaign(

                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("notes"),
                rs.getString("password"));

    }
}
