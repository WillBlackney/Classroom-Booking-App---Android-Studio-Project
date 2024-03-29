package WillBlackney.MandatoryAssignment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddReservationActivity extends AppCompatActivity {

    // Variables
    private ProgressBar progressBar;

    // Logic
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reservation);
        progressBar = findViewById(R.id.addBookProgressbar);
    }

    public void addReservationButtonClicked(View view) {

        ReservationService reservationService = RestController.GetReservationService();
        Reservation reservation = new Reservation();

        Call<Reservation> saveRoomCall = reservationService.saveReservationBody(reservation);
        progressBar.setVisibility(View.VISIBLE);
        saveRoomCall.enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {
                    Reservation theNewReservation = response.body();
                    Log.d("MYROOMS", theNewReservation.toString());
                    Toast.makeText(AddReservationActivity.this, "Reservation added, id: " + theNewReservation.getRoomId(), Toast.LENGTH_SHORT).show();
                } else {
                    String problem = "Problem: " + response.code() + " " + response.message();
                    Log.e("MYROOMS", problem);
                    Toast.makeText(AddReservationActivity.this, problem, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e("MYROOMS", t.getMessage());
            }
        });
    }

}
