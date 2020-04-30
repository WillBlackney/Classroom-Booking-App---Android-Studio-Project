package WillBlackney.MandatoryAssignment;

class RestController
{
    private RestController(){}

    private static final String BASE_URL = "http://anbo-roomreservationv3.azurewebsites.net/api/";

    public static ReservationService GetReservationService()
    {
        return RetrofitClient.getClient(BASE_URL).create(ReservationService.class);
    }

    public static RoomService GetRoomService()
    {
        return RetrofitClient.getClient(BASE_URL).create(RoomService.class);
    }

}
