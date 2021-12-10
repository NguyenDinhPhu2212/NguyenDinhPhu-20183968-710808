package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class controls the flow of place rush order use case in our AIMS project
 * @author NguyenDinhPhu-20183968
 */
public class PlaceRushOrderController {

    /**
     * List provinces that support rush order
     */
    public static List<String> PROVINCES_SUPPORT_RUSH_ODER = List.of("Ha noi",
    		"Ho Chi Minh", "Da Nang");

    /**
     * List media id that support rush order
     */
    public static List<Integer> MEDIA_IDS_SUPPORT_RUSH_ORDER = List.of(12, 20, 22);

    /**
     * Just for logging purpose
     */
    private static final Logger LOGGER = utils.Utils.getLogger(
    		PlaceRushOrderController.class.getName());
    /**
     * Time formatter
     */
    public static final String RECEIVE_TIME_FORMATTER = "dd-MM-yyyy HH:mm";
    
    /**
     * Method validate string without special characters
     * @param info string to check
     * @return true/false
     */
    private boolean validateString(String info) {
        if (info == null || info.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
    	Matcher matcher = pattern.matcher(info.trim().replaceAll("\\s",""));
        if(matcher.find()) return false;

        return true;
    }
    /**
     * Method checks user's location support rush order or not
     * @param location User's province
     */
    public boolean validateLocation(String location) {
        if (location == null) {
            return false;
        }
        if (PROVINCES_SUPPORT_RUSH_ODER.contains(location)) {
            return true;
        }
        return false;
    }

    /**
     * Method checks user's media support rush order or not
     * @param mediaID Cart's media id
     */
    public boolean validateItems(int mediaID) {
        if (MEDIA_IDS_SUPPORT_RUSH_ORDER.contains(mediaID)) {
            return true;
        }
        return false;
    }

    /**
     * Method checks user's info support rush order or not
     * @param location User's province
     * @param mediaID Cart's media id
     */
    public boolean validateRushOrder(String location, int mediaID) {
        return validateLocation(location) && validateItems(mediaID);
    }

    /**
     * Method validates user's receive time
     * @param time User's receive time
     */
    public boolean validateReceiveTime(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RECEIVE_TIME_FORMATTER);
            LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method validates user's rush order info
     * @param info User's rush order info
     */
    public boolean validateRushOrderInfo(String info) {
        return validateString(info);
    }

    /**
     * Method validates user's rush order instruction
     * @param instruction User's rush order instruction
     */
    public boolean validateRushOrderInstruction(String instruction) {
        return validateString(instruction);
    }
}