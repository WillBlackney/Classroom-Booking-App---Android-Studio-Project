package WillBlackney.MandatoryAssignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Reservation implements Serializable
{
    // variables
    @SerializedName("id")
    @Expose
    private Integer  id;

    @SerializedName("fromTime")
    @Expose
    private Integer  fromTime;

    @SerializedName("toTime")
    @Expose
    private Integer  toTime;

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("purpose")
    @Expose
    private String purpose;

    @SerializedName("roomId")
    @Expose
    private Integer roomId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String userID) {
        this.purpose = purpose;
    }

    public int getRoomId(){
        return roomId;
    }
    public void setRoomId(Integer roomId){
        this.roomId = roomId;
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
        this.userId = _userID;
        this.purpose = _purpose;
        this.roomId = _roomID;
    }

    @NonNull
    @Override
    public String toString() {
        return id + ": " + fromTime + " " + toTime + ", " + userId +", " + purpose +", " + roomId;
    }
}