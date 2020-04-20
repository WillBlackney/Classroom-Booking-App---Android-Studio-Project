package WillBlackney.MandatoryAssignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPageActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    public Button signInButton;
    public EditText userNameField;
    public EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();

        signInButton = findViewById(R.id.loginButton);
        userNameField = findViewById(R.id.userNameEditText);
        passwordField = findViewById(R.id.passwordEditText);
    }

    public void onStart(){
        super.onStart();
    }

    public void OnLoginButtonClicked(View view)
    {
        String email = userNameField.getText().toString();
        String password = passwordField.getText().toString();
        TrySignIn(email, password);
    }

    public void TrySignIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            LoadUserFrontPage();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE", "signInWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                  //  Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void LoadUserFrontPage()
    {
        Intent intent = new Intent(getBaseContext(), FrontPageActivity.class);
        startActivity(intent);
    }

}
