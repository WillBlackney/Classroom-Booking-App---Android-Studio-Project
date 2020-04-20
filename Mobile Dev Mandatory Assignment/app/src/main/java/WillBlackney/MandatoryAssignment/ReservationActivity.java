package WillBlackney.MandatoryAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ReservationActivity extends AppCompatActivity {

    public static final String RESERVATION = "RESERVATION";
    private static final String LOG_TAG = "MYRESERVATION";
    private Reservation originalReservation;
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_book);
        messageView = findViewById(R.id.singleBookMessageTextView);

        Intent intent = getIntent();
        originalReservation = (Reservation) intent.getSerializableExtra(RESERVATION);

        Log.d(LOG_TAG, originalReservation.toString());
        TextView headingView = findViewById(R.id.singleBookHeadingTextview);
        headingView.setText("Room Id=" + originalReservation.getRoomId());

        EditText titleView = findViewById(R.id.singleBookTitleEditText);
        titleView.setText(originalReservation.getUserId());

        EditText authorView = findViewById(R.id.singleBookAuthorEditText);
        authorView.setText(originalReservation.getPurpose());

        EditText publisherView = findViewById(R.id.singleBookPublisherEditText);
        publisherView.setText(originalReservation.getFromTime());

        EditText priceView = findViewById(R.id.singleBookPriceEditText);
        priceView.setText(Double.toString(originalReservation.getToTime()));
    }

    public void backButtonClicked(View view) {
        Log.d(LOG_TAG, "backButtonClicked");
        finish();
    }

    public void deleteBookButtonClicked(View view) {
        /*
        RoomService roomService = ApiUtils.getBookStoreService();;
        int roomId = originalRoom.getId();
        Call<Book> deleteBookCall = roomService.deleteBook(roomId);
        messageView.setText("");

        deleteBookCall.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.isSuccessful()) {
                    //Snackbar.make(view, "Book deleted, id: " + originalBook.getId(), Snackbar.LENGTH_LONG).show();
                    String message = "Book deleted, id: " + originalRoom.getId();
                    Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
                    Log.d(LOG_TAG, message);
                } else {
                    //Snackbar.make(view, "Problem: " + response.code() + " " + response.message(), Snackbar.LENGTH_LONG).show();
                    String problem = call.request().url() + "\n" + response.code() + " " + response.message();
                    messageView.setText(problem);
                    //Toast.makeText(getBaseContext(), problem, Toast.LENGTH_SHORT).show();
                    Log.e(LOG_TAG, problem);
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                //Snackbar.make(view, "Problem: " + t.getMessage(), Snackbar.LENGTH_LONG).show();
                Log.e(LOG_TAG, "Problem: " + t.getMessage());
            }
        });
        */

    }

    public void updateButtonClicked(View view) {
        /*
        Log.d(LOG_TAG, "anotherButtonClicked");
        Toast.makeText(this, "anotherButtonClicked", Toast.LENGTH_SHORT).show();

        EditText authorField = findViewById(R.id.singleBookAuthorEditText);
        EditText titleField = findViewById(R.id.singleBookTitleEditText);
        EditText publisherField = findViewById(R.id.singleBookPublisherEditText);
        EditText priceField = findViewById(R.id.singleBookPriceEditText);
        // REST bug: price cannot be updated!

        String author = authorField.getText().toString().trim();
        // TODO check if author is empty string?
        String title = titleField.getText().toString().trim();
        String publisher = publisherField.getText().toString().trim();
        String priceString = priceField.getText().toString().trim();

        double price;
        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException ex) {
            priceField.setError("Not a valid price");
            return;
        }
        Book bookToUpdate = new Book(author, title, publisher, price);
        Log.d(LOG_TAG, "Update " + bookToUpdate);

        RoomService roomService = ApiUtils.getBookStoreService();
        Call<Book> callUpdate = roomService.updateBook(originalRoom.getId(), bookToUpdate);
        callUpdate.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.isSuccessful()) {
                    Log.d(LOG_TAG, response.body().toString());
                    messageView.setText("Updated " + response.body().toString());
                } else {
                    messageView.setText("Problem: " + response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                messageView.setText("Problem: " + t.getMessage());
            }
        });
        */
    }
}
