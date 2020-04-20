package WillBlackney.MandatoryAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FrontPageActivity extends AppCompatActivity {

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
}
