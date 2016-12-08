package edittrackcontroller;

import com.nc.o1.musicmetacollection.controller.EditTrackController;
import com.nc.o1.musicmetacollection.controller.ShowTrackView;
import com.nc.o1.musicmetacollection.model.Artist;
import com.nc.o1.musicmetacollection.model.CommonInfo;
import com.nc.o1.musicmetacollection.model.TechnicalInfo;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Includes test methods of update TrackInfo after call "edit" operation.
 *
 * @author SteVL
 */
public class EditTrackControllerUnitTest {

    /**
     * Test of editing when only Artist and Title are existed. Other fields are
     * empty.
     */
    @Test
    public void setGeneralTrackInfo() {
        //Existing Model that was set to View.
        CommonInfo commonInfoExisting = new CommonInfo();
        commonInfoExisting.setArtist(new Artist("Dropzone"));
        commonInfoExisting.setTitle("Drop It");

        TechnicalInfo technicalInfoExisting = new TechnicalInfo();

        TrackInfo trackExisted = new TrackInfo(commonInfoExisting, technicalInfoExisting);
        //End Existing Model that was set to View.

        //Updated view that should be saved.
        ShowTrackView viewForSave = new ShowTrackView();
        viewForSave.setArtist("Shadowkey");
        viewForSave.setTitle("Move On");
        viewForSave.setGenre("");
        viewForSave.setLatencyHour("");
        viewForSave.setLatencyMin("");
        viewForSave.setLatencySec("");
        viewForSave.setYear("");
        viewForSave.setAlbum("");
        viewForSave.setCoverPath("");
        viewForSave.setComposer("");
        viewForSave.setBpm("");
        viewForSave.setKey("");
        //End Updated view that should be saved.

        //Expected Model after update.
        CommonInfo commonInfoExpected = commonInfoExisting;
        commonInfoExpected.setArtist(new Artist("Dropzone"));
        commonInfoExpected.setTitle("Drop It");

        TechnicalInfo technicalInfoExpected = new TechnicalInfo();

        TrackInfo trackExpected = new TrackInfo();
        trackExpected.setCommonInfo(commonInfoExpected);
        trackExpected.setTechnicalInfo(technicalInfoExpected);
        //End expected Model after update.

        //System.out.println("Before:" + trackExisted.toString());
        //Checking existing model that has been created before call controller.save() and after.
        EditTrackController editCntrl = new EditTrackController(trackExisted, viewForSave);
        editCntrl.saveTrack();
        assertEquals(trackExpected, trackExisted);
        // System.out.println("After:" + trackExisted.toString());
    }
}
