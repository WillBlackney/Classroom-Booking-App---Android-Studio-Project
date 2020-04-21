package WillBlackney.MandatoryAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FrontPageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
    }


    public void OnViewAllRoomsButtonClicked(View view)
    {
        GoToViewAllRoomsPage();
    }

    public void GoToViewAllRoomsPage()
    {
        Intent intent = new Intent(FrontPageActivity.this, ViewAllRoomsActivity.class);
        startActivity(intent);
    }

    public void OnViewAllReservationsButtonClicked(View view)
    {
        GoToViewAllReservationsPage();
    }

    public void GoToViewAllReservationsPage()
    {
        Intent intent = new Intent(FrontPageActivity.this, ViewAllReservationsActivity.class);
        startActivity(intent);
    }

    public void OnBookRoomButtonClicked(View view)
    {
        GoToBookRoomPage();
    }
    public void GoToBookRoomPage()
    {
        Intent intent = new Intent(FrontPageActivity.this, BookRoomActivity.class);
        startActivity(intent);
    }
}
