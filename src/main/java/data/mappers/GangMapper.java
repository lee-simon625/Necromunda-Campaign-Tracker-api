package data.mappers;

import objects.gangs.BaseGang;
import objects.gangs.Gang;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GangMapper {

    public Gang map(ResultSet rs) throws SQLException {
        return new Gang(
                rs.getInt("id"),
                rs.getString("player"),
                rs.getString("gang_name"),
                rs.getString("gang_type"),
                rs.getInt("total_value"));

    }

    public BaseGang baseMap(ResultSet rs) throws SQLException {
        return new BaseGang(
                rs.getInt("id"),
                rs.getString("gang_type"));

    }

}
