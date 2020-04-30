package WillBlackney.MandatoryAssignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ReservationService
{
    @GET("Reservations")
    Call<List<Reservation>> getAllReservations();

    @POST("Reservations")
    Call<Reservation> saveReservationBody(@Body Reservation reservation);

    @DELETE("Reservations/{id}")
    Call<Reservation> deleteReservation(@Path("id") int id);



}
