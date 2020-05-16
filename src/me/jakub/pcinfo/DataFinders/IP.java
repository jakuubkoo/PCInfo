package me.jakub.pcinfo.DataFinders;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.jakub.pcinfo.NewMain;
import me.jakub.pcinfo.Utils.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class IP {

    public String getIP(){
        try {

            JsonObject jsonObject = readJsonFromUrl("https://ip.teoh.io/api/vpn/");
            return jsonObject.get("ip").getAsString();

        } catch (MalformedURLException e) {
            new NewMain().log("Please contact administrator, or try restart your computer.", Type.ERROR);
            new NewMain().log("------------------------------------", Type.EMPTY);
            e.printStackTrace();
            new NewMain().log("------------------------------------", Type.EMPTY);
            return "";
        } catch (IOException e) {
            new NewMain().log("Please contact administrator, or try restart your computer.", Type.ERROR);
            new NewMain().log("------------------------------------", Type.EMPTY);
            e.printStackTrace();
            new NewMain().log("------------------------------------", Type.EMPTY);
            return "";
        }
    }

    public boolean isVPN(){
        try {

            JsonObject jsonObject = readJsonFromUrl("https://ip.teoh.io/api/vpn/");
            return jsonObject.get("vpn_or_proxy").getAsBoolean();

        } catch (MalformedURLException e) {
            new NewMain().log("Please contact administrator, or try restart your computer.", Type.ERROR);
            new NewMain().log("------------------------------------", Type.EMPTY);
            e.printStackTrace();
            new NewMain().log("------------------------------------", Type.EMPTY);
            return false;
        } catch (IOException e) {
            new NewMain().log("Please contact administrator, or try restart your computer.", Type.ERROR);
            new NewMain().log("------------------------------------", Type.EMPTY);
            e.printStackTrace();
            new NewMain().log("------------------------------------", Type.EMPTY);
            return false;
        }
    }

    public JsonObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();

            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }

            JsonObject json = new JsonParser().parse(sb.toString()).getAsJsonObject();

            return json;
        } finally {
            is.close();
        }
    }
}
