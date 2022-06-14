import com.hellokaton.blade.annotation.Path;
import com.hellokaton.blade.annotation.route.GET;


@Path
public class RegisteredPages {
    @GET("/home")
    public String home(){
        return "home.html";
    }

    @GET("/settings")
    public String settings(){
        return "settings.html";
    }
}
