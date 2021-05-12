package data.dao;

import data.MySQLService;
import data.mappers.TerritoryMapper;
import objects.territories.Territory;

import java.sql.*;
import java.util.ArrayList;

public class TerritoryDao {

    public ArrayList<Territory> list(MySQLService service) throws SQLException {
        ArrayList<Territory> territories = new ArrayList<Territory>();
        TerritoryMapper mapper = new TerritoryMapper();
        ResultSet rs = service.call("SELECT * FROM territories");
        while (rs.next()){

            territories.add( mapper.map(rs));
        }
        return territories;
    }



}
