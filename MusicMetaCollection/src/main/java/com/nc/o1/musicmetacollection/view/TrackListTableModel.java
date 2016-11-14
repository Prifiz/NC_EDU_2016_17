package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.model.TrackList;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TrackListTableModel extends AbstractTableModel {

    private TrackList trackList;

    public TrackListTableModel(TrackList trackList) {
        this.trackList = trackList;
    }

    @Override
    public int getRowCount() {
        return trackList.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Исполнитель";
            case 1:
                return "Название";
            case 2:
                return "Альбом";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TrackInfo track = trackList.getTrackInfo(rowIndex);
        switch (columnIndex) {
            case 0:
                return track.getCommonInfo().getArtist().getName();
            case 1:
                return track.getCommonInfo().getTitle();
            case 2:
                return track.getCommonInfo().getAlbumInfo().getAlbum();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TrackInfo track = trackList.getTrackInfo(rowIndex);
        switch (columnIndex) {
            case 0:
                track.getCommonInfo().getArtist().setName((String) aValue);
            case 1:
                track.getCommonInfo().setTitle((String) aValue);
            case 2:
                track.getCommonInfo().getAlbumInfo().setAlbum((String) aValue);
                
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addRow(TrackInfo track) {
        trackList.addTrackInfo(track);
        fireTableDataChanged();
    }

    public TrackInfo getTrackInfo(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < trackList.getSize()) {
            return trackList.getTrackInfo(rowIndex);
        }
        return null;
    }
    
    public void removeRow(int rowIndex){
        if (rowIndex >= 0 && rowIndex < trackList.getSize()) {
            trackList.removeTrackInfo(rowIndex);
            fireTableDataChanged();
        }        
    }

}
