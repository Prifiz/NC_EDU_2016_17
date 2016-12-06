package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.TrackInfo;
import com.nc.o1.musicmetacollection.model.TrackList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Controller in charge of work with serialized file.
 *
 * @author SteVL
 */
public class FileSrlzController {

    private TrackList model;
    /**
     * Creates data for serialized.
     * @param model tracklist. 
     */
    public FileSrlzController(TrackList model) {
        this.model = model;
    }
    /**
     * Empty constructor.
     */
    public FileSrlzController() {
    }
    

    /**
     * Loads Tracklist from serialized file.
     *
     * @param file selected file.
     * @return TrackList model.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public TrackList load(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis;
        fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (TrackList) ois.readObject();
    }
    /**
     * Saves Tracklist to serialized file.
     * @param file
     * @throws IOException 
     */
    public void save(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(model);
    }
}
