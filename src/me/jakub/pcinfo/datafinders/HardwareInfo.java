package me.jakub.pcinfo.datafinders;

import me.jakub.pcinfo.Main;
import me.jakub.pcinfo.utils.Type;

public class HardwareInfo {

    public void getInfo(){
        String numberOfProcessors;

        Main.getInstance().log("Getting number of processors..", Type.INFO);
        numberOfProcessors = System.getenv("NUMBER_OF_PROCESSORS");

        Main.getInstance().clean();
        Main.getInstance().log("Information:", Type.EMPTY);
        Main.getInstance().log("Processor: ", Type.EMPTY);
        Main.getInstance().log("   Number of Processors:" + numberOfProcessors, Type.EMPTY);


    }

}
