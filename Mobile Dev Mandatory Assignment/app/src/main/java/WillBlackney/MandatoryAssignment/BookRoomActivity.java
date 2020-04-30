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

import java.util.Date;
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

        /*
        // Get room ID from user input
        String roomIdString = roomIdEditText.toString();
        Integer roomIdInt = Integer.parseInt(roomIdString);

        // Get from time from user input
        String fromTimeString = startTimeEditText.toString();
        Integer fromTimeInt = Integer.parseInt(fromTimeString);

        // Get from time from user input
        String toTimeString = startTimeEditText.toString();
        Integer toTimeInt = Integer.parseInt(toTimeString);

        // Get date
        String dateString = dateEditText.toString();
        Integer dateInt = Integer.parseInt(dateString);
        */

        // create new reservation (for testing)
        Reservation testReservation = new Reservation(7,1765101022,1765101100,"test ID","lunch",1);

        // is post action valid?
        if(IsRoomBookable(testReservation))
        {
            // Post!!
            PostBooking(testReservation);
        }



    }


    public void PostBooking(Reservation reservation){

        Toast toast = Toast.makeText(getBaseContext(),"Posting booking...",Toast.LENGTH_LONG);
        toast.show();

        Log.d("BoomRoomActivity","PostBooking() called...");
        ReservationService rs = RestController.GetReservationService();


        rs.saveReservationBody(reservation).enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                if(response.body() != null){
                    Log.d("REST.POST","Successfully posted to REST Service, body: " + response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                Log.d("REST.POST","Failure to post to REST Service");
            }
        });
    }

    public boolean IsRoomBookable(Reservation reservation)
    {
        Log.d("BoomRoomActivity","IsRoomBookable() called...");
        return true;
    }

}
