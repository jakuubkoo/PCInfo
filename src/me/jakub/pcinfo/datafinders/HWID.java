package me.jakub.pcinfo.datafinders;

import me.jakub.pcinfo.NewMain;
import me.jakub.pcinfo.utils.Type;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HWID {

    public String getHWID() {
        try {
            String s = "";
            final String main = System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("COMPUTERNAME") + System.getProperty("user.name").trim();
            final byte[] bytes = main.getBytes("UTF-8");
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            final byte[] md5 = messageDigest.digest(bytes);
            int i = 0;
            for (final byte b : md5) {
                s += Integer.toHexString((b & 0xFF) | 0x300).substring(0, 3);
                if (i != md5.length - 1) {
                    s += "-";
                }
                i++;
            }
            return s;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            new NewMain().log("Please contact administrator, or try restart your computer.", Type.ERROR);
            new NewMain().log("------------------------------------", Type.EMPTY);
            e.printStackTrace();
            new NewMain().log("------------------------------------", Type.EMPTY);
            return "";
        }
    }

}
