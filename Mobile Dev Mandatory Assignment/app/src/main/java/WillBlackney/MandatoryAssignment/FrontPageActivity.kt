package WillBlackney.MandatoryAssignment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FrontPageActivity : AppCompatActivity() {
    // Variables
    private var userNameField: EditText? = null

    // Initialization
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)
    }

    override fun onStart() {
        super.onStart()
        userNameField = findViewById(R.id.userNameEditText)
    }

    // Button Click events
    fun OnViewAllRoomsButtonClicked(view: View?) {
        GoToViewAllRoomsPage()
    }
    fun OnViewAllReservationsButtonClicked(view: View?) {
        GoToViewAllReservationsPage()
    }
    fun OnBookRoomButtonClicked(view: View?) {
        GoToBookRoomPage()
    }
    fun OnLogOutButtonClicked(view: View?) {
        GoToLogInScreen()
    }
    fun OnMyReservationsButtonClicked(view: View?) {
        GoToMyReservationsPage()
    }

    // Intents + GUI Logic
    fun GoToViewAllRoomsPage() {
        val intent = Intent(this@FrontPageActivity, ViewAllRoomsActivity::class.java)
        startActivity(intent)
    }
    fun GoToViewAllReservationsPage() {
        val intent = Intent(this@FrontPageActivity, ViewAllReservationsActivity::class.java)
        startActivity(intent)
    }
    fun GoToBookRoomPage() {
        val intent = Intent(this@FrontPageActivity, BookRoomActivity::class.java)
        startActivity(intent)
    }
    fun GoToLogInScreen() {
        FireBaseManager.HandleLogOut()
        val intent = Intent(baseContext, LoginPageActivity::class.java)
        startActivity(intent)
    }
    fun GoToMyReservationsPage() {
        val intent = Intent(this@FrontPageActivity, MyBookingsActivity::class.java)
        startActivity(intent)
    }
}