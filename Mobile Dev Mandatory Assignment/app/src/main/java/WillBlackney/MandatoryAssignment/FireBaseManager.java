package WillBlackney.MandatoryAssignment;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

class FireBaseManager
{
    // Base constructor
    public FireBaseManager()
    {

    }

    // Variables
    public static FirebaseAuth authorizer;
    public static FirebaseUser currentUser;
    public static boolean alreadyInitialized;

    // Initialization
    public static void Initialize()
    {
        Log.d("FIREBASE", "FireBaseManager.Initialize() called...");
        if(!alreadyInitialized)
        {
            alreadyInitialized = true;
            authorizer = FirebaseAuth.getInstance();
        }
        else
            {
            Log.d("FIREBASE", "Manager has already been initialized...");
        }

    }

    // Get + Set Firebase Data
    public static FirebaseUser GetCurrentUser()
    {
        Log.d("FIREBASE", "FireBaseManager.GetCurrentUser() called...");
        return currentUser;
    }
    public static void SetCurrentUser(FirebaseUser newUser)
    {
        Log.d("FIREBASE", "FireBaseManager.SetCurrentUser() called...");
        currentUser = newUser;
    }

    // Conditional Checks
    public static boolean IsUserLoggedIn()
    {
        if (currentUser != null)
        {
            return true;
        }
        else
            {
            return false;
        }
    }

    // Log out
    public static void HandleLogOut()
    {
        Log.d("FIREBASE","FireBaseManager.HandleLogOut() called...");
        SetCurrentUser(null);

    }
}