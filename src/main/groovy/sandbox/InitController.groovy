package sandbox

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class InitController {

    @RequestMapping("/")
    String redirectFirstPage() {
        return "redirect:payroll/";
    }

}
