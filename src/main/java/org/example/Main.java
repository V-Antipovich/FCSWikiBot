package org.example;

import org.example.bot.TelegramBot;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.lang.model.util.Elements;
import java.io.IOException;
//import org.jsoup.Jsoup

public class Main {
    public static void main(String[] args) throws TelegramApiException, IOException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TelegramBot());

        /*
        String url = "http://wiki.cs.hse.ru/DM1PMIbase-2023-24";
        Connection connection = Jsoup.connect(url);
        try {
            Connection.Response resp = connection.execute();
            System.out.println(resp);
            System.out.println(resp.statusCode());
            Document doc = null; // connection.get();
            System.out.println("0. Код 200");
            // Вся страница
            doc = connection.get();
            System.out.println("1. Всю страницу спарсили");
            // Только полезный контент (целиком)
            Element pageContent = doc.getElementById("mw-content-text");
            System.out.println("2. Спарсили полезный контент");
            Element lastNews = pageContent.select("p").first();
            System.out.println("3. Спарсили последнюю новость");
            String lastNewsDate = lastNews.select("b").first().ownText();
            System.out.println("4. Спарсили дату новости");
            String lastNewsText = lastNews.ownText();
            System.out.println("5. Текст новости");
            System.out.println(lastNewsDate);
            System.out.println(lastNewsText);
            // .D0.9E.D0.91.D0.AA.D0.AF.D0.92.D0.9B.D0.95.D0.9D.D0.98.D0.AF
            // .D0.9C.D0.B0.D1.82.D0.B5.D1.80.D0.B8.D0.B0.D0.BB.D1.8B_.D0.BA.D1.83.D1.80.D1.81.D0.B0
        } catch (Exception e) {
            // TODO: Что-то сделать с повторным обращением к серверу
            System.out.println("Сервер недоступен");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
        */

//        if (resp.statusCode() == 200){
//
//        }
//        else {
//
//        }
//        System.out.println(doc);
//        Document doc = new Document();
//        System.out.println(url);
    }
}
