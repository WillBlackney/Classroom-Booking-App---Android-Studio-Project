package WillBlackney.MandatoryAssignment;

class ApiUtils {
    private ApiUtils() {

    }

     private static final String BASE_URL = "http://anbo-roomreservationv3.azurewebsites.net/api/";

    public static ReservationService getReservationService() {

        return RetrofitClient.getClient(BASE_URL).create(ReservationService.class);
    }

    public static RoomService getRoomService() {

        return RetrofitClient.getClient(BASE_URL).create(RoomService.class);
    }

}
