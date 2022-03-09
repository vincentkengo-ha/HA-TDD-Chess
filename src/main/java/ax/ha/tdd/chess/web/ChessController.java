package ax.ha.tdd.chess.web;

import ax.ha.tdd.chess.engine.Chessboard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChessController {

    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        model.addAttribute("chessboard",
                new ChessboardView(Chessboard.startingBoard()));
        return "chess";
    }

}
