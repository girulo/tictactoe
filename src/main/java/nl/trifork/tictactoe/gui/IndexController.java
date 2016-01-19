package nl.trifork.tictactoe.gui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author plaarakkers
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index() {
        return "index";
    }
}
