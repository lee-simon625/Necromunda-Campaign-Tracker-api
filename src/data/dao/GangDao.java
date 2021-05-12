package data.dao;

import data.MySQLService;
import data.mappers.GangMapper;
import objects.gangs.Gang;

import java.sql.*;
import java.util.ArrayList;

public class GangDao {

    public ArrayList<Gang> list(MySQLService service) throws SQLException {
        ArrayList<Gang> gangs = new ArrayList<Gang>();
        GangMapper mapper = new GangMapper();
        ResultSet rs = service.call("SELECT * FROM gangs");
        while (rs.next()) {

            gangs.add(mapper.map(rs));
        }
        return gangs;
    }
}
