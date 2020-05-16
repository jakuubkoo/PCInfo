package me.jakub.pcinfo.datafinders;

import me.jakub.pcinfo.NewMain;
import me.jakub.pcinfo.utils.Type;

public class HardwareInfo {

    public void getInfo(){
        String numberOfProcessors;

        NewMain.getInstance().log("Getting number of processors..", Type.INFO);
        numberOfProcessors = System.getenv("NUMBER_OF_PROCESSORS");

        NewMain.getInstance().clean();
        NewMain.getInstance().log("Information:", Type.EMPTY);
        NewMain.getInstance().log("Processor: ", Type.EMPTY);
        NewMain.getInstance().log("   Number of Processors:" + numberOfProcessors, Type.EMPTY);


    }

}
