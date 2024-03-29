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

public class ViewAllRoomsActivity extends AppCompatActivity
{
    private static final String LOG_TAG = "MYROOMS";
    private TextView messageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_rooms);

        messageView = findViewById(R.id.mainMessageTextView);
        progressBar = findViewById(R.id.mainProgressbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
           Intent intent = new Intent(ViewAllRoomsActivity.this, AddRoomActivity.class);
           startActivity(intent);
        });

        SwipeRefreshLayout refreshLayout = findViewById(R.id.mainSwiperefresh);
        refreshLayout.setOnRefreshListener(() -> {
            getAndShowAllRooms();
            //getAndShowRoomById(1);
            refreshLayout.setRefreshing(false);
        });



    }
    @Override
    protected void onStart() {
        super.onStart();
        getAndShowAllRooms();
        //getAndShowRoomById(1);
    }

    private void getAndShowAllRooms()
    {
        messageView.setText("");
        progressBar.setVisibility(View.VISIBLE);


        RoomService roomService = RestController.GetRoomService();
        Call<List<Room>> getAllRoomsCall = roomService.getAllRooms();
        //Log.d(LOG_TAG, "All rooms GET string: " + roomService.getAllRooms().toString());

        messageView.setText("");
        progressBar.setVisibility(View.VISIBLE);

        getAllRoomsCall.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                try {Thread.sleep(5000);}
                catch (InterruptedException e) { }

                progressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful())
                {

                    Log.d(LOG_TAG, "All rooms GET string: " + response.body().toString());

                    List<Room> allRooms = response.body();
                    Log.d(LOG_TAG, allRooms.toString());
                    populateRecyclerView(allRooms);
                } else
                    {
                    String message = "Problem " + response.code() + " " + response.message();
                    Log.d(LOG_TAG, message);
                    messageView.setText(message);
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e(LOG_TAG, t.getMessage());
                messageView.setText(t.getMessage());
            }
        });


    }

    private void getAndShowRoomById(int id)
    {
        RoomService roomService = RestController.GetRoomService();
        Call<List<Room>> getAllRoomsCall = roomService.getAllRooms();
        //Log.d(LOG_TAG, "All rooms GET string: " + roomService.getAllRooms().toString());

        messageView.setText("");
        progressBar.setVisibility(View.VISIBLE);

        getAllRoomsCall.enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                }

                progressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()) {

                    Log.d(LOG_TAG, "All rooms GET string: " + response.body().toString());

                    List<Room> allRooms = response.body();
                    Room matchingRoom = null;

                    for(Room roomy: allRooms)
                    {
                        if(id == roomy.getID())
                        {
                            matchingRoom = roomy;
                            Log.d(LOG_TAG, "Found a matching room with ID: " + roomy.getID().toString());
                        }
                    }

                    if(matchingRoom != null)
                    {
                        allRooms.clear();
                        allRooms.add(matchingRoom);
                        populateRecyclerView(allRooms);
                    }

                } else {
                    String message = "Problem " + response.code() + " " + response.message();
                    Log.d(LOG_TAG, message);
                    messageView.setText(message);
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e(LOG_TAG, t.getMessage());
                messageView.setText(t.getMessage());
            }
        });
    }

    private void populateRecyclerView(List<Room> allRooms) {
        RecyclerView recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewSimpleAdapter<Room> adapter = new RecyclerViewSimpleAdapter<>(allRooms);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((view, position, item) -> {
            Room room = (Room) item;
            Log.d(LOG_TAG, item.toString());
            Intent intent = new Intent(ViewAllRoomsActivity.this, RoomActivity.class);
            intent.putExtra(RoomActivity.ROOM, room);
            Log.d(LOG_TAG, "putExtra " + room.toString());
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
