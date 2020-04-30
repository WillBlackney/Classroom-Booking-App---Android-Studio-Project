package WillBlackney.MandatoryAssignment;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RoomService
{
    @GET("Rooms")
    Call<List<Room>> getAllRooms();

    @POST("Rooms")
    Call<Room> saveRoomBody(@Body Room room);






}
