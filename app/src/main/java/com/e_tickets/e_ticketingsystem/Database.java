package com.e_tickets.e_ticketingsystem;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;


public class Database extends AsyncTask<String, Void, Offenderclass> {
    private Offenderclass offenderclass = null;
    private Connection connection = null;
    private Offense offense = null;
    private Context ctx;

    public Database(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected Offenderclass doInBackground(String... params) {
        String method = params[0];
        String evaluator = params[1];
        if (method.equalsIgnoreCase("TicketMethod")) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
                Connection connection = DriverManager.getConnection(url, "user", "password");

                Statement statement = connection.createStatement();
                this.offenderclass = new Offenderclass();
                ResultSet resultSet = statement.executeQuery("SELECT firstName, lastName,email,gender,vehicleRegNum,photo " +
                        "FROM userlogin u1,commuter c1,commitoffense co1 " +
                        "WHERE u1.userID='" + evaluator + "'" +
                        "AND c1.licenseNum='" + evaluator + "'" + "AND co1.licenseNum='" + evaluator + "'");
                while (resultSet.next()) {
                    offenderclass.setFname(resultSet.getString("firstName"));
                    offenderclass.setL_name(resultSet.getString("lastName"));
                    offenderclass.setEmail(resultSet.getString("email"));
                    offenderclass.setGender(resultSet.getString("gender"));
                    offenderclass.setVehicleRegnum(resultSet.getInt("vehicleRegNum"));
                    offenderclass.setPhoto(resultSet.getBlob("photo"));


                }

                return offenderclass;
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

        if (method.equalsIgnoreCase("Police Login")) {
            offenderclass = new Offenderclass();
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
                Connection connection2 = DriverManager.getConnection(url, "user", "password");
                Statement statement2 = connection2.createStatement();
                ResultSet resultSet = statement2.executeQuery("SELECT stationCode FROM police WHERE badgeNum='" + evaluator + "'");
                while (resultSet.next()) {
                    offenderclass.setPolice_pass(resultSet.getString("stationCode"));
                }

                return offenderclass;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (method.equalsIgnoreCase("Vehicle Info")) {
            Offenderclass offenderclass = new Offenderclass();
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
                Connection connection3 = DriverManager.getConnection(url, "user", "password");
                Statement statement3 = connection3.createStatement();
                ResultSet resultSet = statement3.executeQuery("SELECT make, model,vehicleType,vehicleOwner FROM" +
                        " vehicle " + "WHERE registerationNum='" + evaluator + "'");
                while (resultSet.next()) {
                    offenderclass.setMake(resultSet.getString("make"));
                    offenderclass.setModel(resultSet.getString("model"));
                    offenderclass.setVehicleType(resultSet.getString("vehicleType"));
                    offenderclass.setOwner(resultSet.getString("vehicleOwner"));

                }

                return offenderclass;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (method.equalsIgnoreCase("Commuter Login")) {
            offenderclass = new Offenderclass();
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
                Connection connection2 = DriverManager.getConnection(url, "user", "password");
                Statement statement2 = connection2.createStatement();
                ResultSet resultSet = statement2.executeQuery("SELECT firstName, userPassword, photo,offenseCode FROM userlogin u1, commuter c1, " +
                        "commitoffense co1 " +
                        "WHERE u1.userID='" + evaluator + "'"
                        + "AND c1.licenseNum='" + evaluator + "'" + "AND co1.licenseNum='" + evaluator + "'");
                while (resultSet.next()) {
                    offenderclass.setFname(resultSet.getString("firstName"));
                    offenderclass.setCommuterpass(resultSet.getString("userPassword"));
                    offenderclass.setPhoto(resultSet.getBlob("photo"));
                    offenderclass.setOffenseCode(resultSet.getString("offenseCode"));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return offenderclass;

        }

        if (method.equalsIgnoreCase("Get ticket info")) {
            offenderclass = new Offenderclass();
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
                Connection connection2 = DriverManager.getConnection(url, "user", "password");
                Statement statement2 = connection2.createStatement();
                ResultSet resultSet = statement2.executeQuery("SELECT ticketNum,violation,ticketTime,ticketFine " +
                        "FROM ticket WHERE offenseCode="+evaluator);


                while (resultSet.next()) {
                    offenderclass.setTicketnum(resultSet.getString("ticketNum"));
                    offenderclass.setOffenseCom(resultSet.getString("violation"));
                    offenderclass.setDate(resultSet.getString("ticketTime"));
                    offenderclass.setFeeOffense(resultSet.getString("ticketFine"));
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return offenderclass;
        }
    return offenderclass;
    }

}



