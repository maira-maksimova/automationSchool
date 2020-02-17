import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResourceResponse {
    int total_pages;
    ArrayList<Resource> data;

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<Resource> getData() {
        return data;
    }

    public void setData(ArrayList<Resource> data) {
        this.data = data;
    }
}