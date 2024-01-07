package org.example.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

// TODO: DisMathParser наследник WikiParser
public class DisMathParser extends WikiParser {

    public DisMathParser(String url){
        super(url);
//        this.pageConnection =
    }
    public String getLastNews(){
        String text = "";
        try {
            if (this.isAvaliable()) {
                Document doc = this.pageConnection.get();
                Element pageContent = doc.getElementById("mw-content-text");
                Element lastNews = pageContent.select("p").first();
                String lastNewsDate = lastNews.select("b").first().ownText();
                String lastNewsText = lastNews.ownText();
                text = String.format("Последняя новость от %s \n%s", lastNewsDate, lastNewsText);
            }
            else {
                throw new IOException();
            }

        } catch (IOException ioe) {
            text = "Извините, после нескольких попыток подключения вики-страница всё ещё не отвечает (Проблема на стороне ФКН, а не бота). Попробуйте повторить через минуту.";
        }

        return text;
    }
}
