package swingy.model.getinfo;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteException;

import swingy.model.board.Map;

public class UserData {

    private static final String DATA_BASE_URL = "jdbc:sqlite:swingy.db";
    private static Connection connection;

    public static void connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DATA_BASE_URL);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        connection = conn;
    }

    public static void close() {
        try {
            if (connection != null)
                connection.close();
            connection = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection getConnection() {
        if (connection == null)
            connect();
        return connection;
    }

    public void Data(String hero_name, String hero_class, int level, int experience, int attack, int defense,
            int hitpoints) {
        try {
            String createTable = "CREATE TABLE IF NOT EXISTS heroes "
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, hero_name TEXT, hero_class TEXT, level INTEGER, experience INTEGER,"
                    + "attack INTEGER, defense INTEGER," + "hitpoints INTEGER,  UNIQUE (hero_name, hero_class))";
            Statement stmt = getConnection().createStatement();
            stmt.executeUpdate(createTable);
        } catch (Exception e) {
            System.out.println("Something went wrong while creating a table: " + e.getMessage());
        }
        String sqlQuery = "INSERT INTO heroes " + "(hero_name,hero_class,level,experience,attack,defense,hitpoints)"
                + " VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sqlQuery)) {
            pstmt.setString(1, hero_name);
            pstmt.setString(2, hero_class);
            pstmt.setInt(3, level);
            pstmt.setInt(4, experience);
            pstmt.setInt(5, attack);
            pstmt.setInt(6, defense);
            pstmt.setInt(7, hitpoints);
            pstmt.executeUpdate();

            GetData(hero_name, hero_class);
        } catch (SQLException e) {
            System.out.println("in the Data: " + e.getMessage());
        }
    }

    public void GetData(String hero_name, String hero_class) {
        String selectHero = "SELECT * FROM heroes WHERE hero_name = ? AND hero_class = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(selectHero)) {
            statement.setString(1, hero_name);
            statement.setString(2, hero_class);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int level = resultSet.getInt("level");
                int experience = resultSet.getInt("experience");
                int attack = resultSet.getInt("attack");
                int defence = resultSet.getInt("defense");
                int hitpoints = resultSet.getInt("hitpoints");

                Map map = new Map(hero_name, hero_class, level, experience, attack, defence, hitpoints);
                map.fillMap();
                map.presentBoard();
                map.move();
            }
        } catch (SQLException e) {
            System.out.println("in the GetData: " + e.getMessage());
        }
    }

    public void UpData(String hero_name, String hero_class, int level, int experience, int attack, int defense,
            int hitpoints) {
        String Update = "UPDATE  heroes SET level = ?, attack = ?, experience = ?, defense = ?, hitpoints = ? WHERE hero_name = ? AND hero_class = ?";
        try (PreparedStatement pstmt = getConnection().prepareStatement(Update)) {
            pstmt.setInt(1, level);
            pstmt.setInt(2, attack);
            pstmt.setInt(3, defense);
            pstmt.setInt(4, experience);
            pstmt.setInt(5, hitpoints);

            pstmt.setString(6, hero_name);
            pstmt.setString(7, hero_class);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("in the UpDate: " + e.getMessage());
        }
    }
}