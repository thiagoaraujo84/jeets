package org.jeets.player.sources;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeets.player.Player;
import org.jeets.protocol.Traccar;
import org.jeets.tracker.Tracker;

import de.hvv.rest.GeoFoxException;

public class GeoFoxFactory {

    /**
     * This class is currently used for server development.
     * Idea is to start via command line and simulate a train on track
     * until it has reached its final destination.
     * 
     * @param args - currently hard coded in main method
     */
    public static void main(String[] args) {
        
        /** Dev Note 9.6.17
         * Currently the jar-with-deps requires a manual change
         * as described in RESTEASY003145.txt !!
         * 
         * Dev Note 6.6.17
         * The Factory can be launched from command line for server development
         * currently the time stamps are not LIVE > analyze AND implement Timer scheduling !
         * currently the time stamps are (sometimes?) from the previous day! > debug geofox
         */

        // lineKey = uniqueId -> derive name = "U1"
        String lineKey = "HHA-U:U1_HHA-U",  
        departureString = "Jungfernstieg",
        viaString = "Hallerstraße";
        int departureOffset = 35; // [min]
        
        GeoFox geoFox = new GeoFox();
//      TODO: REWRITE TO POSTION ENTITIES !!!
        List<Traccar.Position.Builder> positionBuilders = null;
        try {
            positionBuilders = geoFox.getLiveTrack(lineKey, departureString, viaString, departureOffset);
        } catch (GeoFoxException e) {
            logger.error("Problems with GeoFox REST service: " + e.getMessage());
            logger.error("For a manual fix of RESTEASY003145 see RESTEASY003145.txt in this project");
        }
//      optimize track by adding altitude and calculating course and speed attributes

//      2. create Player
        Player player = new Player();
        player.setProtoPositionBuilders(positionBuilders);

//      3. create Tracker as Player Listener !
        Tracker tracker = new Tracker("localhost", 5200, lineKey);
        player.addListener(tracker);

//      4. play
        player.playProtos();

    }

    private static Log logger = LogFactory.getLog(GeoFoxFactory.class);
}
