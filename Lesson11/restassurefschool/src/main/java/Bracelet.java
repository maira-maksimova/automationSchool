import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bracelet {
    @Getter @Setter private String guid;
    @Getter @Setter private String braceletId;
    @Getter @Setter private String pin;

}