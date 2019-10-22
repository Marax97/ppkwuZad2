package ppkwu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class LetterTypeController {

    @GetMapping("/ppkwu/lowercaseLetters")
    @ResponseBody
    public Long countUpperCaseLetters(@RequestParam(name="text", required=true) String text) {
        return text.codePoints().filter(c -> Character.isUpperCase(c)).count();
    }

    @GetMapping("/ppkwu/uppercaseLetters")
    @ResponseBody
    public Long countLowerCaseLetters(@RequestParam(name="text", required=true) String text) {
        return text.codePoints().filter(c -> Character.isLowerCase(c)).count();
    }

    @GetMapping("/ppkwu/specialLetters")
    @ResponseBody
    public Long countSpecialLetters(@RequestParam(name="text", required=true) String text) {
        return text.codePoints().filter(c -> c >= 'A' && c <= 'Z' || c >='a' && c <='z' || c >= '0' && c <= '1').count();
    }

    @GetMapping("/ppkwu/digits")
    @ResponseBody
    public Long countDigits(@RequestParam(name="text", required=true) String text) {
        return text.codePoints().filter(c -> Character.isDigit(c)).count();
    }
}
