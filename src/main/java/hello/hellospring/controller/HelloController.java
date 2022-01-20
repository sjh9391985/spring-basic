package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


    /*
    @GetMapping("hello-string")
    @ResponseBody // ResponseBody 사용 시 viewResolver를 사용하지 않습니다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }
    */

    /*
    @GetMapping("hello-mvc")
    // 외부에서 파라미터를 받을 때 RequestParam 사용 ex. url/?name="~~"
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    */

    /*
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    */
}
