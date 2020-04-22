package WillBlackney.MandatoryAssignment;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class BookRoomActivity extends AppCompatActivity
{
    // Variables
    public EditText roomIdEditText;
    public EditText dateEditText;
    public EditText startTimeEditText;
    public EditText endTimeEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);

        // find and cache edit text variables
        roomIdEditText = findViewById(R.id.roomIdField);
        dateEditText = findViewById(R.id.dateField);
        startTimeEditText = findViewById(R.id.startTimeField);
        endTimeEditText = findViewById(R.id.endTimeField);
    }

    public void OnBookRoomButtonClicked(View view)
    {
        Log.d("BoomRoomActivity","OnBookRoomButtonClicked() called...");

        // Get room ID from user input
        String roomIdString = roomIdEditText.toString();
        Integer roomIdInt = Integer.parseInt(roomIdString);

        // Get from time from user input
        String fromTimeString = startTimeEditText.toString();
        Integer fromTimeInt = Integer.parseInt(fromTimeString);

        // Get from time from user input
        String toTimeString = startTimeEditText.toString();
        Integer toTimeInt = Integer.parseInt(toTimeString);

        // get room from rest
        Room room = GetRoomById((roomIdInt));

        // check that rooms exists and is available
        if(room != null && IsRoomBookable(room) && FireBaseManager.IsUserLoggedIn())
        {
            // room available, make booking
            BookingManager.CreateBooking(room.getID(),room.getName(), FireBaseManager.GetCurrentUser().getEmail(), fromTimeInt, toTimeInt);
            Log.d("BoomRoomActivity","Booking Successful");
            Toast.makeText(BookRoomActivity.this, "Booking Successful",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            // room not available for booking
            Log.d("BoomRoomActivity","Booking Failed");
            Toast.makeText(BookRoomActivity.this, "Booking Failed",
                    Toast.LENGTH_SHORT).show();
        }

    }
    public boolean IsRoomBookable(Room room)
    {
        Log.d("BoomRoomActivity","IsRoomBookable() called...");
        return true;
    }
    public Room GetRoomById(Integer id)
    {
        Log.d("BoomRoomActivity","GetRoomById() called, ID: " + id.toString());

        List<Room> allRooms = ApiManager.GetAllRooms();

        Room roomReturned = null;
        for(Room roomy: allRooms)
        {
            if(roomy.getID() == id){
                roomReturned = roomy;
            }
        }

        if(roomReturned ==  null){
            Log.d("BookRoomActivity","WARNING! BookRoomActivity.GetRoomById() returning null!!");
        }

        return roomReturned;
    }
}
