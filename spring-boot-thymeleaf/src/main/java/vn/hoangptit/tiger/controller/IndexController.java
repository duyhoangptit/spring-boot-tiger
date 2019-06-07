package vn.hoangptit.tiger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.hoangptit.tiger.dto.InfoDTO;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("")
    public String index(Model model) {
        List<InfoDTO> infos = new ArrayList<>();

        infos.add(new InfoDTO("FullName", "Tạ Duy Hoàng"));
        infos.add(new InfoDTO("Nickname", "duyhoangptit"));
        infos.add(new InfoDTO("email", "duyhoangptit@gmail.com"));
        infos.add(new InfoDTO("facebook", "https://www.facebook.com/hoangptit94"));

        model.addAttribute("infos", infos);

        return "index";
    }
}
