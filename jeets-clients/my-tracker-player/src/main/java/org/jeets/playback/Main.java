package org.jeets.playback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jeets.model.traccar.jpa.Position;
import org.jeets.playback.sources.DatabaseFactory;
import org.jeets.player.Player;
import org.jeets.player.SampleReceiver;

public class Main {

//  server parameters for all factories
    // static final String HOST = System.getProperty("host", "127.0.0.1");
    // static final int PORT = Integer.parseInt(System.getProperty("port","5200"));
    // load traccar's default.xml for available protocols and ports!!

    public static void main(String[] args) {

        List<Position> positionEntities;
        Main main = new Main();
        {   // 1. create position list with any factory

//          a. DB factory
            positionEntities = main.selectPositionsFromDB();

//          b. GTFS-DB factory
//          c. REST API factory (GeoFox -> confidential !!)
        
        }
//      position list ready for playback
        System.out.println(positionEntities.size() + " positions retrieved ");
        
        // 2. prepare Position-Entity List (do this internally ? / in Player !)
        preparePositionsForReplay(positionEntities);
        
        // 3. create Player
        Player player = new Player(positionEntities);
        // player.setPositionEntities(positionEntities);

//      Tracker and Server parameters 
        String server = "localhost";
        int port = 5200; // traccar: <entry key='pb.device.port'>5200</entry>
        String toUniqueId = "pb.device.echo";   // must be registered!
        
        // 4. create Tracker as Player Listener !
        PlaybackReceiver receiver = new PlaybackReceiver();
        player.addListener(receiver);

        // 5. play
        player.startPlayback();

        // 6. done
        System.out.println("End Main");
        return;
    }

    /**
     * Modify Positions for 'live' playback.
     * <p>
     * The Fixtimes should not be sent from the past time and are therefore set
     * to the time they are actually played to listeners. <br>
     * Many other modifications according to the setup can be added as needed.
     */
    private static void preparePositionsForReplay(List<Position> positionEntities) {
        long msOffset = new Date().getTime() - positionEntities.get(0).getFixtime().getTime();
        for (Position position : positionEntities) {
            // adjust fixtimes starting first position from 'now'
            Date newFixtime = new Date(position.getFixtime().getTime() + msOffset);
            position.setFixtime(newFixtime);
            // clear attributes {..} to null
            // not needed: clear servertime
        }
    }

    private List<Position> selectPositionsFromDB() {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/traccar3.14";
        String persistenceUnit = "jeets-pu-traccar-jpa";
        DatabaseFactory db = new DatabaseFactory(jdbcUrl, persistenceUnit);

        String fromDevice = "pb.device";
        Date fromDate = parseDate("2017-05-20 16:10:00");
        Date   toDate = parseDate("2017-05-20 17:43:00");
        List<Position> positionEntities = db.selectPositionList(fromDevice, fromDate, toDate);
//      System.out.println(positionEntities.size() + " positions " + "for device " + fromDevice);

//      DEBUG: main method doesn't terminate (here) > close db, EMgr .. ?

        return positionEntities;
    }
    
    private static Date parseDate(String timestamp) {
        Date date = null;
        String dateFormat = "yyyy-M-dd hh:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            date = sdf.parse(timestamp);
        } catch (ParseException e) {
            System.err.println("Error parsing the Date String: " + timestamp + " to dataformat: " + dateFormat);
            // usage(); DateFormat
            System.exit(1);
        }
        return date;
    }

}