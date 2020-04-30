package WillBlackney.MandatoryAssignment;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyBookingsActivity extends AppCompatActivity
{
    // Properties
    public EditText roomIdEditText;

    // Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        roomIdEditText = findViewById(R.id.roomIdField);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void OnDeleteBookingButtonClicked(View view)
    {
        DeleteBooking();
    }
    public void DeleteBooking()
    {
        Toast toast = Toast.makeText(getBaseContext(),"Deleting booking...",Toast.LENGTH_LONG);
        toast.show();

        Log.d("MyBookingsActivity","DeleteBooking() called...");

        // Get room ID from user input
        String roomIdString = roomIdEditText.getText().toString();
        Integer roomIdInt = Integer.parseInt(roomIdString);

        // Get rest
        ReservationService rs = RestController.GetReservationService();

        Call<Reservation> deleteRequest = rs.deleteReservation(roomIdInt);
        deleteRequest.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                Log.d("MyBookingsActivity","DELETE request successful");
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                Log.d("MyBookingsActivity","DELETE request failed");
            }
        });

    }

}
