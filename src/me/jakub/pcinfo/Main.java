package me.jakub.pcinfo;

import me.jakub.pcinfo.datafinders.HWID;
import me.jakub.pcinfo.datafinders.HardwareInfo;
import me.jakub.pcinfo.datafinders.IP;
import me.jakub.pcinfo.utils.NumberUtils;
import me.jakub.pcinfo.utils.Type;

import java.util.Scanner;

public class Main {

    public static Main getInstance() {
        return new Main();
    }

    private NumberUtils numUtil = new NumberUtils();
    private HWID hwid = new HWID();
    private IP ip = new IP();
    private HardwareInfo hardwareInfo = new HardwareInfo();

    public static void main(String[] args){
        Main.getInstance().start();
    }

    public void start(){

        String type = printTypes(false);

        while(type.isEmpty() || !numUtil.isItNumber(type)){
            log("Wrong type of info! Try again.", Type.ERROR);
            type = printTypes(true);
        }

        System.out.println(type);

        if("1".equals(type)){
            hardwareInfo.getInfo();
        }else if("2".equals(type)){
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
            default:
                log("Unknown error! Please restart application.", Type.ERROR);
                break;
        }

    }

    public void clean(){
        for (int i = 0; i < 50; i++){
            System.out.println(" ");
        }
    }
}
