package WillBlackney.MandatoryAssignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReservationService
{
    @GET("Reservations")
    Call<List<Reservation>> getAllReservations();

    @POST("Reservations")
    Call<Reservation> saveReservationBody(@Body Reservation reservation);


    @GET("Reservations/{reservationID}")
    Call<Reservation> getReservationByID(@Path("reservationID") int reservationID);

    /*
    @POST("rooms")
    @FormUrlEncoded
        // I had problems making this work. I used saveBookBody instead
    Call<Reservation> saveRoom(@Field("Author") String author, @Field("Title") String title,
                               @Field("Publisher") String publisher, @Field("Price") double price);
*/

    @DELETE("Reservations/{id}")
    Call<Reservation> deleteReservation(@Path("id") int id);

    @PUT("Reservations/{id}")
    Call<Reservation> updateReservation(@Path("id") int id, @Body Reservation reservation);


}
