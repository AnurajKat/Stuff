package xyz.anuraj.SpringBoot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.anuraj.Stuff.Useless.api.WhyApi;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("${openapi.useless.base-path:}")
public class UselessApiController implements WhyApi {

    public UselessApiController() {
    }

    @Override
    public ResponseEntity<List<String>> whyCall() {
        List<String> results =Arrays.asList("yo","why","did","you","call","this","api?");
        return ResponseEntity.ok(results);
    }
}
