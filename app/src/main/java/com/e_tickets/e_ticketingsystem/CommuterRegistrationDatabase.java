package com.e_tickets.e_ticketingsystem;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class CommuterRegistrationDatabase extends AsyncTask<Offenderclass,Void,String> {
    private String status = "";
    @Override
    protected String doInBackground(Offenderclass...params) {
        Offenderclass off1 = params[0];

        if (off1 != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
                Connection connection = DriverManager.getConnection(url, "user", "password");

                Statement statement = connection.createStatement();

                String sql = "INSERT INTO userlogin(userID,userPassword,firstName,lastName,middleName"
                        + ")" +
                        "VALUES(" + "'" + off1.getTRN()+ "'" + ","
                        +"'"+ off1.getCommuterpass()+"'"+ ","
                        + "'" + off1.getF_name() + "'" +","+"'"+off1.getL_name()+
                        "'"+","+"'"+off1.getMid_name()+"'"+");";
                statement.executeUpdate(sql);

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
            status = "Servers Updated successfully";
            return status;
        } else status = "Unsuccessful update";
        return status;


    }
}
