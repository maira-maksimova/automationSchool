import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import my.reqres.User;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPage {

    User[] data;

    public User[] getData() {
        return data;
    }

    public void setData(User[] data) {
        this.data = data;
    }

//getters and setters

}