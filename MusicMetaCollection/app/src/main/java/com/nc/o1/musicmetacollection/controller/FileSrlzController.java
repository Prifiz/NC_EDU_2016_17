package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.TrackInfo;
import com.nc.o1.musicmetacollection.model.TrackList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Controller in charge of work with serialized file.
 *
 * @author SteVL
 */
public class FileSrlzController {

    /**
     * Load Tracklist from serialized file.
     *
     * @param file selected file.
     * @return TrackList model.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public TrackList load(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis;
        fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (TrackList) ois.readObject();
    }
}
