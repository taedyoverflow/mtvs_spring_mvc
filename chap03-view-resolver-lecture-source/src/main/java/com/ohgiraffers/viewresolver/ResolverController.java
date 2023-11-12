package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {

        /* ViewResolver(뷰 해석기) 인터페이스를 구현한 ThymeleafViewResolver를 이용하고 있다.
        * 접두사(prefix) : resources/templates/
        * 접미사(suffix) : .html
        *  */

        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함...");

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(Model model) {

        model.addAttribute("message1", "문자열로 뷰 이름 반환하여 리다이렉트");

        return "redirect:/";
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes rttr) {

        rttr.addFlashAttribute("flashMessage1", "리다이랙트 attr 사용하여 redirect...");

        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelAndViewTest(ModelAndView mv) {

        mv.addObject("forwardMessage", "ModelAndView를 이용한 모델과 뷰 반환");
        mv.setViewName("result");

        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv) {

        mv.addObject("message2", "ModelAndView를 이용한 redirect");
        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr) {

        rttr.addFlashAttribute("flashMessage2", "ModelAndView를 이용한 redirect attr");
        mv.setViewName("redirect:/");

        return mv;
    }
}
