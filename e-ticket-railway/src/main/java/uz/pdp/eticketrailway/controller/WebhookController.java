package uz.pdp.eticketrailway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.eticketrailway.bot.Bot;
import uz.pdp.eticketrailway.service.BotService;
import uz.pdp.eticketrailway.utils.interfaces.Constant;

import static uz.pdp.eticketrailway.utils.interfaces.Url.BASE_WEBHOOK;

@RestController
@RequestMapping(BASE_WEBHOOK)
@RequiredArgsConstructor
public class WebhookController {

    private final Bot bot;
    private final BotService botService;

    @PostMapping
    public void getRequests(@RequestBody Update update) {
        if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            if (data.equals(Constant.SKIP)) return;
            if (data.equals(Constant.DELETE)){
                botService.deleteMessage(update);
                return;
            }
            if (data.startsWith(Constant.PREV) || data.startsWith(Constant.NEXT)) {
                botService.switchDate(update);
                return;
            }
        }
        bot.onUpdateToReceived(update);
    }
}
