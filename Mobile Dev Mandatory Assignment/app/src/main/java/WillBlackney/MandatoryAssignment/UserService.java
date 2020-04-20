package WillBlackney.MandatoryAssignment;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface UserService
{
    @GET
    public Call<ResponseBody> profilePicture(@Url String url);
}
