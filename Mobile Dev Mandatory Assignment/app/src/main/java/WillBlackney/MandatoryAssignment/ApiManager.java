package WillBlackney.MandatoryAssignment;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ApiManager
{
    // Constructor
    public ApiManager()
    {
    }


    public static List<Room> GetAllRooms()
    {
        Log.d("ApiManager", "GetAllRooms() called... " );

        RoomService roomService = RestController.GetRoomService();
        Call<List<Room>> getAllRoomsCall = roomService.getAllRooms();
        List<Room> allRooms = new ArrayList<Room>();

        getAllRoomsCall.enqueue(new Callback<List<Room>>()
        {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                try {Thread.sleep(5000); }
                catch(InterruptedException e) { }
                if (response.isSuccessful())
                {
                    Log.d("ApiManager", "All rooms GET string: " + response.body().toString());

                    List<Room> foundRooms = response.body();
                    Log.d("ApiManager", foundRooms.toString());
                    allRooms.addAll(foundRooms);
                }
                else
                    {
                    String message = "Problem " + response.code() + " " + response.message();
                }
            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t)
            {
                Log.e("ApiManager", t.getMessage());
            }


        });

        return allRooms;
    }


}
