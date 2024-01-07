package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.HashSet;
import org.example.parser.DisMathParser;
public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        String replyText = "";
        HashSet<String> commands = new HashSet<>(Arrays.asList("/start", "/disnews", "/disroom")); //{"/start", "/disnews", "/disroom"};
        if (update.getMessage().isCommand()) {
//            replyText = "Команда" + text;
            if (commands.contains(text)) {
                if (text.equals("/start")) {
                    replyText = "Добро пожаловать! Воспользуйся списком команд и выбери нужную опцию";
                } else if (text.startsWith("/dis")) {
//                    wikiParser = new WikiParser;
                    DisMathParser parser = new DisMathParser("http://wiki.cs.hse.ru/DM1PMIbase-2023-24");
                    if (text.equals("/disnews")){
                        replyText = parser.getLastNews();
                    }
                    else {
                        replyText = "ЗАГЛУШКА Сервер работает, будет тебе дискра. Потом.";
                    }
//                    if (parser.isAvaliable()){
//
//                        replyText = "ЗАГЛУШКА Сервер работает, ща будет тебе дискра";
//                    } else {
//                        replyText = "Извините, после нескольких попыток подключения вики-страница всё ещё не отвечает. Попробуйте повторить через минуту.";
//                    }
//                    replyText = String.format("Команда %s : сервер работает? %b ", text, wikiParser.isAvaliable());
//                    String tempAvailable = ""
//                    if (wikiParser.isAvaliable()) {
//                        tempAvailable =
//                    }
//                    replyText = "ЗАГЛУШКА Парсить страничку дискры";
                }
            } else {
                replyText = "Не знаю такой команды... Посмотри правильную в списке";
            }
        } else {
            replyText = "Используй команды, чтобы получить желаемое";
//            sendMessage.setText("Используй команды, чтобы получить желаемое");
        }
        sendMessage.setText(replyText);
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.botUsername;
    }

    @Deprecated
    public String getBotToken() {
        return BotConfig.botToken;
    }
}
