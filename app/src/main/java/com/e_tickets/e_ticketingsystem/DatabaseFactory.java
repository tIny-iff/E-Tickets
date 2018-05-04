package com.e_tickets.e_ticketingsystem;

/**
 * Created by Kerrs Unit on 27/04/2018.
 */

import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class DatabaseFactory extends AsyncTask<Void, Void, Connection> {

    @Override
    protected Connection doInBackground(Void...voids) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://192.168.2.8:3306/ticket_database";
            Connection connection = DriverManager.getConnection(url, "user", "password");

            return connection;
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
             catch (SQLException e) {
                e.printStackTrace();
            }

    catch (NullPointerException e)
    {
        e.printStackTrace();
    }

        return null;
    }


}
