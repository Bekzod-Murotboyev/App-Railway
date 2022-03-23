package uz.pdp.eticketrailway.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.eticketrailway.payload.UserInfoDTO;
import uz.pdp.eticketrailway.service.BotService;
import uz.pdp.eticketrailway.utils.enums.BotState;

import java.time.LocalDate;

import static uz.pdp.eticketrailway.utils.enums.BotState.*;
import static uz.pdp.eticketrailway.utils.interfaces.Constant.*;

@Service
@RequiredArgsConstructor
public class Bot {

    private final BotService botService;

    public void onUpdateToReceived(Update update) {
        UserInfoDTO userInfoDTO = botService.getAndCheck(update);
        if(!userInfoDTO.isActive()){
            botService.sendBunWarning(update);
            return;
        }
        BotState state = userInfoDTO.getState();
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                String text = message.getText();
                if (text.equals(COMMAND_START))
                    state = BotState.MAIN_MENU_SEND;
                else if (text.equals(BACK) && state.equals(MENU_REGISTER))
                    state = SETTINGS_MENU_SEND;
                else
                    state = MAIN_MENU_SEND;
            }else if(message.hasContact()){
                state=SETTINGS_MENU_SEND;
            }
        } else if (update.hasCallbackQuery()) {
            state = switch (update.getCallbackQuery().getData()) {
                case SETTINGS -> SETTINGS_MENU_EDIT;
                case REGISTER -> MENU_REGISTER;
                case BACK_TO_GET_FROM_REGION,SEARCH -> GET_FROM;
                case BACK_TO_MAIN_MENU -> MAIN_MENU_EDIT;
                case BACK_TO_GET_TO_REGION -> GET_TO;
                case BACK_TO_GET_DATE -> GET_DATE;
                default -> botService.getState(update);
            };
        }
        if(state.equals(SKIP_ACTION))return;
        switch (state) {
            case SEND_WARNING -> botService.getWarningSend(update,REGISTER_WARNING_TEXT,SETTINGS);
            case MAIN_MENU_SEND -> botService.getMainMenuSend(update);
            case MAIN_MENU_EDIT -> botService.getMainMenuEdit(update);
            case SETTINGS_MENU_SEND -> {
                botService.removeKeyBoardMarkup(update);
                botService.getSettingsMenuSend(update);
            }
            case SETTINGS_MENU_EDIT -> botService.getSettingsMenuEdit(update);
            case MENU_REGISTER -> {
                botService.deleteMessage(update);
                botService.getMenuRegister(update);
            }
            case GET_FROM -> botService.getFromCity(update);
            case GET_TO -> botService.geToCity(update);
            case GET_DATE -> botService.getDate(update, LocalDate.now());
            case SHOW_STATIONS -> botService.showStations(update);
            case SHOW_TRAIN -> botService.showTrain(update);
            case SHOW_CAR -> botService.showCar(update);
        }

        botService.saveUserData(update, state);
    }
}
