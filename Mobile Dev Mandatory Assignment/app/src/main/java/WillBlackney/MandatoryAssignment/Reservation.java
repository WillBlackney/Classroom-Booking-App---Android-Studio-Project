package WillBlackney.MandatoryAssignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Reservation implements Serializable
{
    // variables
    @SerializedName("ID")
    @Expose
    private Integer  id;

    @SerializedName("From Time")
    @Expose
    private Integer  fromTime;

    @SerializedName("To Time")
    @Expose
    private Integer  toTime;

    @SerializedName("User ID")
    @Expose
    private String userID;

    @SerializedName("Purpose")
    @Expose
    private String purpose;

    @SerializedName("Room ID")
    @Expose
    private Integer roomID;

    // Properties + getters
    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public Integer getFromTime() {
        return fromTime;
    }

    public void setFromTime(Integer fromTime) {
        this.fromTime = fromTime;
    }

    public Integer getToTime() {
        return toTime;
    }

    public void setToTime(Integer toTime) {
        this.toTime = toTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String userID) {
        this.purpose = purpose;
    }

    public int getRoomId(){
        return roomID;
    }
    public void setRoomID(Integer roomID){
        this.roomID = roomID;
    }



    // Constructors
    public Reservation()
    {

    }
    public Reservation(Integer _id, Integer _fromTime, Integer _toTime, String _userID, String _purpose, Integer _roomID)
    {
        this.id = _id;
        this.fromTime =_fromTime;
        this.toTime = _toTime;
        this.userID = _userID;
        this.purpose = _purpose;
        this.roomID = _roomID;
    }

    @NonNull
    @Override
    public String toString() {
        return id + ": " + fromTime + " " + toTime + ", " + userID +", " + purpose +", " + roomID;
    }
}