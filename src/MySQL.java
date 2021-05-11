import java.sql.*;

class Mysql {


    public static void AllTerritories() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/necromunda", "Simon", "password");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from territories");

            while (rs.next()) {
                if (rs.getString(2) != null) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }
                if (rs.getString(3) != null) {
                    System.out.println("Income:      " + rs.getString(3));
                }
                if (rs.getString(4) != null) {
                    System.out.println("Recruit:     " + rs.getString(4));
                }
                if (rs.getString(5) != null) {
                    System.out.println("Equipment:  " + rs.getString(5));
                }
                if (rs.getString(6) != null) {
                    System.out.println("Special:     " + rs.getString(6));
                }
                if (rs.getString(7) != null) {
                    System.out.println("Reputation:  " + rs.getString(7));
                }
                System.out.println();
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void OwnedTerritory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/necromunda", "Simon", "password");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT territories.name, gangs.player\n" +
                    "FROM campaign_gangs_territories\n" +
                    "INNER JOIN territories ON campaign_gangs_territories.territory_id=territories.id\n" +
                    "INNER JOIN gangs ON campaign_gangs_territories.gang_id=gangs.id\n" +
                    "ORDER BY gangs.player, territories.name;\n");
            while (rs.next())

                System.out.println(rs.getString(2) + "   " + rs.getString(1));

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void AllTerritoryOwner() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/necromunda", "Simon", "password");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT territories.name, gangs.player\n" +
                    "FROM campaign_gangs_territories\n" +
                    "INNER JOIN territories ON campaign_gangs_territories.territory_id=territories.id\n" +
                    "left JOIN gangs ON campaign_gangs_territories.gang_id=gangs.id\n" +
                    "ORDER BY territories.name, gangs.player;");
            while (rs.next())

                System.out.println(rs.getString(2) + "   " + rs.getString(1));

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void UnownedTerritory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/necromunda", "Simon", "password");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT territories.name, territories.income, territories.recruit, territories.equipment, territories.special, territories.reputation\n" +
                    "FROM campaign_gangs_territories\n" +
                    "INNER JOIN territories ON campaign_gangs_territories.territory_id=territories.id\n" +
                    "WHERE campaign_gangs_territories.gang_id IS NULL\n" +
                    "ORDER BY territories.name;\n");
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    System.out.println(rs.getString(1));
                }
                if (rs.getString(2) != null) {
                    System.out.println("Income:      " + rs.getString(2));
                }
                if (rs.getString(3) != null) {
                    System.out.println("Recruit:     " + rs.getString(3));
                }
                if (rs.getString(4) != null) {
                    System.out.println("Equipment:  " + rs.getString(4));
                }
                if (rs.getString(5) != null) {
                    System.out.println("Special:     " + rs.getString(5));
                }
                if (rs.getString(6) != null) {
                    System.out.println("Reputation:  " + rs.getString(6));
                }
                System.out.println();
            }


            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }


}