package WillBlackney.MandatoryAssignment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddReservationActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        progressBar = findViewById(R.id.addBookProgressbar);
    }

    public void addReservationButtonClicked(View view) {
        EditText authorField = findViewById(R.id.addRoomIdEditText);
        EditText titleField = findViewById(R.id.addRoomNameEditText);
        EditText publisherField = findViewById(R.id.addRoomDescriptionEditText);
        EditText priceField = findViewById(R.id.addRoomCapacityEditText);

        String author = authorField.getText().toString().trim();
        // TODO check if author is empty string?
        String title = titleField.getText().toString().trim();
        String publisher = publisherField.getText().toString().trim();
        String priceString = priceField.getText().toString().trim();

        double price;
        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException ex) {
            priceField.setError("Not a valid price");
            return;
        }

        ReservationService reservationService = ApiUtils.getReservationService();
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
                    Toast.makeText(AddReservationActivity.this, "Room added, id: " + theNewReservation.getRoomId(), Toast.LENGTH_SHORT).show();
//                    Snackbar.make(view, "Room added, id: " + theNewRoom.getID(), Snackbar.LENGTH_LONG).show();
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
