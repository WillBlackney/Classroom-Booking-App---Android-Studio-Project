package WillBlackney.MandatoryAssignment;

import java.util.List;

class BookingManager
{
    public BookingManager()
    {

    }

    public static List<Booking> userBookings;

    public static void CreateBooking(Integer roomID, String roomName, String userName, Integer fromTime, Integer toTime)
    {
        Booking newBooking = new Booking(roomID, roomName, userName, fromTime, toTime);
        userBookings.add(newBooking);

    }
    public static List<Booking> GetAllUserBookings()
    {
        return userBookings;
    }

}