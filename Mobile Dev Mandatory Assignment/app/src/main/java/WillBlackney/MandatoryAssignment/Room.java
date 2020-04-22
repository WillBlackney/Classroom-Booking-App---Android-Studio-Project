package WillBlackney.MandatoryAssignment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Room implements Serializable
{
    // variables
    @SerializedName("id")
    @Expose
    private Integer  id;

    @SerializedName("name")
    @Expose
    private String  name;

    @SerializedName("description")
    @Expose
    private String  description;

    @SerializedName("capacity")
    @Expose
    private Integer capacity;

    @SerializedName("remarks")
    @Expose
    private String remarks;


    // Properties + getters
    public Integer getID() {
        return id;
    }
    public void setID(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    // Constructors
    public Room()
    {
        // Empty constructor for Json + Gson
    }
    public Room(Integer _id, String _name, String _description, Integer _capacity, String _remarks)
    {
        this.id = _id;
        this.name =_name;
        this.description = _description;
        this.capacity = _capacity;
        this.remarks = _remarks;
    }

    @NonNull
    @Override
    public String toString() {
        return id + ": " + name + " " + description + ", " + capacity +", " + remarks;
    }
}