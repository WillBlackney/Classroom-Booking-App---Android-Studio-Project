package WillBlackney.MandatoryAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FrontPageActivity extends AppCompatActivity
{
    // Variables
    public EditText userNameField;

    // Initialization
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
    }
    @Override
    protected void onStart() {
        super.onStart();
        userNameField = findViewById(R.id.userNameEditText);
    }

    // Button Click events
    public void OnViewAllRoomsButtonClicked(View view)
    {
        GoToViewAllRoomsPage();
    }
    public void OnViewAllReservationsButtonClicked(View view)
    {
        GoToViewAllReservationsPage();
    }
    public void OnBookRoomButtonClicked(View view)
    {
        GoToBookRoomPage();
    }
    public void OnLogOutButtonClicked(View view)
    {
        GoToLogInScreen();
    }
    public void OnMyReservationsButtonClicked(View view)
    {
        GoToMyReservationsPage();
    }

    // Intents + GUI Logic
    public void GoToViewAllRoomsPage() {
        Intent intent = new Intent(FrontPageActivity.this, ViewAllRoomsActivity.class);
        startActivity(intent);
    }
    public void GoToViewAllReservationsPage() {
        Intent intent = new Intent(FrontPageActivity.this, ViewAllReservationsActivity.class);
        startActivity(intent);
    }
    public void GoToBookRoomPage()  {
        Intent intent = new Intent(FrontPageActivity.this, BookRoomActivity.class);
        startActivity(intent);
    }
    public void GoToLogInScreen() {
        FireBaseManager.HandleLogOut();
        Intent intent = new Intent(getBaseContext(), LoginPageActivity.class);
        startActivity(intent);
    }
    public void GoToMyReservationsPage()  {
        Intent intent = new Intent(FrontPageActivity.this, MyBookingsActivity.class);
        startActivity(intent);
    }
}
