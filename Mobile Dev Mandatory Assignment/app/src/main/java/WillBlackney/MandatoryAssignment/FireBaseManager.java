package WillBlackney.MandatoryAssignment;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

class FireBaseManager
{
    public FireBaseManager()
    {

    }

    public static FirebaseAuth authorizer;

    public static FirebaseUser currentUser;

    public static boolean alreadyInitialized;

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
}