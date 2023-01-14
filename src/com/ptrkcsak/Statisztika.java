package com.ptrkcsak;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Statisztika {
    Connection conn;

    public Statisztika() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "");
    }

    Scanner sc = new Scanner(System.in);

    public ArrayList<Konyv> ListaFeltoltes() throws SQLException {
        ArrayList<Konyv> lista = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM books;";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            int id = result.getInt("id");
            String title = result.getString("title");
            String author = result.getString("author");
            int publish_year = result.getInt("publish_year");
            int page_count = result.getInt("page_count");

            Konyv elem = new Konyv(id, title, author, publish_year, page_count);
            lista.add(elem);
        }
        return lista;
    }

}
