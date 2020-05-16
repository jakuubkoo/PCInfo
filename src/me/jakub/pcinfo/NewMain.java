package me.jakub.pcinfo;

import me.jakub.pcinfo.DataFinders.HWID;
import me.jakub.pcinfo.DataFinders.HardwareInfo;
import me.jakub.pcinfo.DataFinders.IP;
import me.jakub.pcinfo.Utils.NumberUtils;
import me.jakub.pcinfo.Utils.Type;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NewMain {

    public NumberUtils numUtil = new NumberUtils();
    private HWID hwid = new HWID();
    private IP ip = new IP();
    private HardwareInfo hardwareInfo = new HardwareInfo();

    public void start(){

        String type = printTypes(false);

        while(type.isEmpty() || !numUtil.isItNumber(type)){
            log("Wrong type of info! Try again.", Type.ERROR);
            type = printTypes(true);
        }

        System.out.println(type);

        if(type.equals("1")){
            hardwareInfo.getInfo();
        }else if(type.equals("2")){
            log("Getting information from computer..", Type.INFO);
            log("Getting OS info..", Type.INFO);
            String OSName = System.getProperty("os.name");
            String OSArchitecture = System.getProperty("os.arch");
            String OSVersion = System.getProperty("os.version");
            log("Getting Java info..", Type.INFO);
            String javaVer = System.getProperty("java.version");
            log("Getting User info..", Type.INFO);
            String username = System.getProperty("user.name");
            String userDir = System.getProperty("user.home");
            log("Getting HWID..", Type.INFO);
            String HWID = hwid.getHWID();
            log("Getting IP..", Type.INFO);
            String IP = ip.getIP();
            log("Getting VPN usage..", Type.INFO);
            boolean VPN = ip.isVPN();
            clean();
            log("Information:", Type.EMPTY);
            log("OS Name: " + OSName, Type.EMPTY);
            log("OS Architecture: " + OSArchitecture, Type.EMPTY);
            log("OS Version: " + OSVersion, Type.EMPTY);
            log("Java Version: " + javaVer, Type.EMPTY);
            log("User Name: " + username, Type.EMPTY);
            log("User Directory: " + userDir, Type.EMPTY);
            log("HWID: " + HWID, Type.EMPTY);
            log("IP: " + IP, Type.EMPTY);
            log("Using VPN: " + VPN, Type.EMPTY);
        }else{
            log("Unknown error! Please restart application.", Type.ERROR);
            System.exit(0);
        }

    }

    public String printTypes(boolean wrong) {
        Scanner sc = new Scanner(System.in);

        if (!wrong) {
            log("Hello, here is some types of info, please choice some type:", Type.EMPTY);
        } else {
            log("Here is some types of info, please choice some type:", Type.EMPTY);
        }

        log("[1] Hardware info", Type.EMPTY);
        log("[2] Software info", Type.EMPTY);
        return sc.nextLine();
    }

    public void log(String info, Type type){

        switch (type) {
            case INFO:
                System.out.println("[INFO] " + info);
                break;
            case ERROR:
                System.out.println("[ERROR] " + info);
                break;
            case WARNING:
                System.out.println("[WARNING] " + info);
                break;
            case EMPTY:
                System.out.println(info);
                break;
        }

    }

    public void clean(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
