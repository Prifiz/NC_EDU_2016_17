package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.view.MainFrame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Undefined
 */
public class Controller {
    
    public static StringBuffer readHelp() throws IOException {
        BufferedReader reader;
        String [] readyHelp;
        reader=new BufferedReader(new FileReader("src/help.txt"));
        
        StringBuffer filetext=new StringBuffer();
        while(reader.ready()){
            filetext.append(reader.readLine());
            filetext.append("\n");
        }
        
//        String str=String.valueOf(filetext);
//        readyHelp=str.split("\n");
        
        reader.close();
        return filetext;  
    }
    
    public static void parseXML(String path, MainFrame frame){
        
    }
}
