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
/*

    @GET("Rooms/{ID}")
    Call<Reservation> getReservationByID(@Path("reservationID") int reservationID);


    @POST("rooms")
    @FormUrlEncoded
        // I had problems making this work. I used saveBookBody instead
    Call<Reservation> saveRoom(@Field("Author") String author, @Field("Title") String title,
                               @Field("Publisher") String publisher, @Field("Price") double price);


    @DELETE("Reservations/{id}")
    Call<Reservation> deleteBook(@Path("id") int id);

    @PUT("Reservations/{id}")
    Call<Reservation> updateBook(@Path("id") int id, @Body Reservation reservation);
    */


}
