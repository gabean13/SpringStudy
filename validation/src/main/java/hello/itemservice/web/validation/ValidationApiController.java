package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/validation/api/items")
public class ValidationApiController {

    @PostMapping("/add")
    public Object addItem(@Validated @ModelAttribute ItemSaveForm form, BindingResult bindingResult){
        log.info("로직 실행");

        if (bindingResult.hasErrors()) {
            log.info("erros = {}", bindingResult);
            return bindingResult.getAllErrors();
        }

        log.info("로직성공");
        return form;
    }
}
