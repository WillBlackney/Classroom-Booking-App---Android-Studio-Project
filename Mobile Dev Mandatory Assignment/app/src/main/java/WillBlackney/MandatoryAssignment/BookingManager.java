package WillBlackney.MandatoryAssignment;

import java.util.List;

class BookingManager
{
    // Base constructor
    public BookingManager()
    {

    }

    // Variables
    public static List<Booking> userBookings;

    // Logic
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