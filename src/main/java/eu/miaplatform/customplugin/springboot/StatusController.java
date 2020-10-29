package eu.miaplatform.customplugin.springboot;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import eu.miaplatform.customplugin.springboot.*;

@RestController
@Api(value = "Status Routes")
public class StatusController extends CPStatusController {
}
