package WillBlackney.MandatoryAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
    }

    public void OnLoginButtonClicked(View view)
    {
        LoadUserFrontPage();
    }

    public void LoadUserFrontPage()
    {
        Intent intent = new Intent(getBaseContext(), FrontPageActivity.class);
        startActivity(intent);
    }
}
