package xyz.anuraj.SpringBoot.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.anuraj.Stuff.Useless.api.PingApi;
import xyz.anuraj.Stuff.Useless.api.PingResponse;

@Controller
@RequestMapping("${openapi.useless.base-path:}")
public class PingApiController implements PingApi {

    @Value("${test.value}")
    private final String testValue;

    public PingApiController() {
        testValue = "Value NOt Set";
    }

    @Override
    public ResponseEntity<Object> getPing() {
        PingResponse pingResponse = new PingResponse();

        pingResponse.setResult(testValue);
        return ResponseEntity.ok(pingResponse);
    }
}
