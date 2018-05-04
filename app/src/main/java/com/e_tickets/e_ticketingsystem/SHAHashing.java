package com.e_tickets.e_ticketingsystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAHashing {
    public String hashPassword(String password) {
        String hashedPassword = "";

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());

            byte byteData[] = messageDigest.digest();

            StringBuffer buffer = new StringBuffer();

            for (int index = 0; index < byteData.length; index++) {
                String hex = Integer.toHexString(0xff & byteData[index]);

                if(hex.length()==1) buffer.append('0');
                buffer.append(hex);
            }

            hashedPassword = buffer.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }
}