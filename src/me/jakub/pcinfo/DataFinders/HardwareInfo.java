package me.jakub.pcinfo.DataFinders;

import me.jakub.pcinfo.NewMain;
import me.jakub.pcinfo.Utils.Type;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class HardwareInfo {

    public void getInfo(){
        String numberOfProcessors;

        new NewMain().log("Getting number of processors..", Type.INFO);
        numberOfProcessors = System.getenv("NUMBER_OF_PROCESSORS");

        new NewMain().clean();
        new NewMain().log("Information:", Type.EMPTY);
        new NewMain().log("Processor: ", Type.EMPTY);
        new NewMain().log("   Number of Processors:" + numberOfProcessors, Type.EMPTY);


    }

}
