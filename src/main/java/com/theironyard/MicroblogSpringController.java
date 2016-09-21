package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by lindseyringwald on 9/20/16.
 */
@Controller
public class MicroblogSpringController {
    private static ArrayList<Person> people = new ArrayList<>();
    ArrayList<Message> messages = new ArrayList<>();


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", session.getAttribute("messages"));
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String newMessage(HttpSession session, String addMessage) {

//        session.setAttribute("userName", userName);

        Message message = new Message(addMessage);
        messages.add(message);

        session.setAttribute("messages", messages);

        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(HttpSession session, String userName, String deleteMessage) {
        int id = Integer.parseInt(deleteMessage);
        for(int i = 0; i < messages.size(); i++) {
            if (messages.get(i).equals(id)) {
                messages.remove(i);
            }
        }

        return "redirect:/";
    }
}
