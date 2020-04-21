package WillBlackney.MandatoryAssignment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewController {
    public RecyclerViewController()
    {

    }

    public static void PopulateRecyclerView(List<Room> allRooms, RecyclerView recyclerView, Context context, Intent intent)
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerViewSimpleAdapter<Room> adapter = new RecyclerViewSimpleAdapter<>(allRooms);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((view, position, item) -> {
            Room room = (Room) item;
            //Log.d(LOG_TAG, item.toString());
            //Intent intent = new Intent(ViewAllRoomsActivity.this, RoomActivity.class);
            //intent.putExtra(RoomActivity.ROOM, room);
            //Log.d(LOG_TAG, "putExtra " + room.toString());
            context.startActivity(intent);
        });
    }
}