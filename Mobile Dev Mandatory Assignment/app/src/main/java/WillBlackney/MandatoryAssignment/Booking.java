package WillBlackney.MandatoryAssignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Booking
{
    // Variables
    @SerializedName("roomId")
    @Expose
    private Integer roomId;

    @SerializedName("roomName")
    @Expose
    private String roomName;

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("fromTime")
    @Expose
    private Integer  fromTime;

    @SerializedName("toTime")
    @Expose
    private Integer  toTime;

    // Properties
    public void SetRoomID(Integer _roomId){
        roomId = roomId;
    }
    public Integer GetRoomID(){
        return roomId;
    }
    public void SetRoomName(String _roomName){
        roomName = _roomName;
    }
    public String GetRoomName(){ return roomName;}
    public void SetUserName(String _userName){
        userName = _userName;
    }
    public String GetUserName(){
        return userName;
    }
    public void SetFromTime(Integer _fromTime){
        fromTime = _fromTime;
    }
    public Integer GetFromTime(){
        return fromTime;
    }
    public void SetToTime(Integer _toTime){
        toTime = _toTime;
    }
    public Integer GetToTime(){
        return toTime;
    }

    // Constructors
    public Booking(Integer _roomID, String _roomName, String _userName, Integer _fromTime, Integer _toTime)
    {
        SetRoomID(_roomID);
        SetRoomName(_roomName);
        SetUserName(_userName);
        SetFromTime(_fromTime);
        SetToTime(_toTime);
    }
    public Booking()
    {
        // empty constructor for Json/Gson
    }
}
