package WillBlackney.MandatoryAssignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewAllReservationsActivity extends AppCompatActivity
{
    private static final String LOG_TAG = "MYROOMS";
    private TextView messageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_reservations);

        messageView = findViewById(R.id.mainMessageTextView);
        progressBar = findViewById(R.id.mainProgressbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ViewAllReservationsActivity.this, AddReservationActivity.class);
            startActivity(intent);
        });

        SwipeRefreshLayout refreshLayout = findViewById(R.id.mainSwiperefresh);
        refreshLayout.setOnRefreshListener(() -> {
            getAndShowAllReservations();
            refreshLayout.setRefreshing(false);
        });



    }
    @Override
    protected void onStart() {
        super.onStart();
        getAndShowAllReservations();
    }

    private void getAndShowAllReservations() {
        ReservationService reservationService = ApiUtils.getReservationService();
        Call<List<Reservation>> getAllRoomsCall = reservationService.getAllReservations();
        //Log.d(LOG_TAG, "All rooms GET string: " + roomService.getAllRooms().toString());

        messageView.setText("");
        progressBar.setVisibility(View.VISIBLE);

        getAllRoomsCall.enqueue(new Callback<List<Reservation>>() {
            @Override
            public void onResponse(Call<List<Reservation>> call, Response<List<Reservation>> response) {
                try {
                    Thread.sleep(5000);
                    // sleep a little to get a chance to see the progressbar in action
                    // don't do this at home
                } catch (InterruptedException e) {
                }
                progressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {

                    Log.d(LOG_TAG, "All rooms GET string: " + response.body().toString());

                    List<Reservation> allRooms = response.body();
                    Log.d(LOG_TAG, allRooms.toString());
                    populateRecyclerView(allRooms);
                } else {
                    String message = "Problem " + response.code() + " " + response.message();
                    Log.d(LOG_TAG, message);
                    messageView.setText(message);
                }
            }

            @Override
            public void onFailure(Call<List<Reservation>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e(LOG_TAG, t.getMessage());
                messageView.setText(t.getMessage());
            }
        });
    }
    private void populateRecyclerView(List<Reservation> allReservations) {
        RecyclerView recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewSimpleAdapter<Reservation> adapter = new RecyclerViewSimpleAdapter<>(allReservations);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((view, position, item) -> {
            Reservation reservation = (Reservation) item;
            Log.d(LOG_TAG, item.toString());
            Intent intent = new Intent(WillBlackney.MandatoryAssignment.ViewAllReservationsActivity.this, ReservationActivity.class);
            intent.putExtra(ReservationActivity.RESERVATION, reservation);
            Log.d(LOG_TAG, "putExtra " + reservation.toString());
            startActivity(intent);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnBackToFrontPageButtonClicked(View view)
    {
        ReturnToFrontPage();
    }
    public void ReturnToFrontPage(){
        Intent intent = new Intent(getBaseContext(), FrontPageActivity.class);
        startActivity(intent);
    }

}
