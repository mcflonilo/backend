import com.example.backend_utvikling.HTTPClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class httpclientTest {


    @Test
    public void shouldDoSomething(){
        HTTPClient client = new HTTPClient("httpbin.org", 80, "/html");
        assert client.statuscode == 200;
        System.out.println(client.body);
        //assert that header.get(content type) != null
        }

}