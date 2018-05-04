package com.e_tickets.e_ticketingsystem;

import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OffensedatabaseTask extends AsyncTask<String,Void,Offense> {
    private  Offense offenseobj = new Offense();
    @Override
    protected Offense doInBackground(String... params) {
    String offense = params[0];


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
            Connection connection = DriverManager.getConnection(url, "user", "password");
            Statement statement = connection.createStatement();


                ResultSet resultSet = statement.executeQuery("SELECT points, fine FROM offense WHERE offenseName='" + offense + "'");
                while (resultSet.next()) {
                    offenseobj.setPoints(resultSet.getInt("points"));
                    offenseobj.setFine(resultSet.getInt("fine"));
                }

            return offenseobj;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;

    }
    }