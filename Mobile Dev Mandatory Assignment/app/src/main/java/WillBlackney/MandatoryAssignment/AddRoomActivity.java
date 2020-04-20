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

public class AddRoomActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        progressBar = findViewById(R.id.addBookProgressbar);
    }

    public void addRoomButtonClicked(View view) {
        EditText idField = findViewById(R.id.addRoomIdEditText);
        EditText nameField = findViewById(R.id.addRoomNameEditText);
        EditText descriptionField = findViewById(R.id.addRoomDescriptionEditText);
        EditText capacityField = findViewById(R.id.addRoomCapacityEditText);
        EditText remarksField = findViewById(R.id.addRoomRemarksEditText);


        RoomService roomService = ApiUtils.getRoomService();
        Room room = new Room();

        Call<Room> saveRoomCall = roomService.saveRoomBody(room);
        progressBar.setVisibility(View.VISIBLE);
        saveRoomCall.enqueue(new Callback<Room>() {
            @Override
            public void onResponse(Call<Room> call, Response<Room> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {
                    Room theNewRoom = response.body();
                    Log.d("MYROOMS", theNewRoom.toString());
                    Toast.makeText(AddRoomActivity.this, "Room added, id: " + theNewRoom.getID(), Toast.LENGTH_SHORT).show();
//                    Snackbar.make(view, "Room added, id: " + theNewRoom.getID(), Snackbar.LENGTH_LONG).show();
                } else {
                    String problem = "Problem: " + response.code() + " " + response.message();
                    Log.e("MYROOMS", problem);
                    Toast.makeText(AddRoomActivity.this, problem, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Room> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e("MYROOMS", t.getMessage());
            }
        });
    }
}
