package org.example.parser;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WikiParser {
    private final String wikiPageUrl;
    protected Connection pageConnection;
    protected Connection.Response pageResponse;

    public WikiParser(String url) {
        this.wikiPageUrl = url;
    }

    protected boolean isAvaliable() {
        if (this.pageResponse == null) {
            this.pageResponse = getResponse();
        }
        return !(this.pageResponse == null);
    }

    protected Connection.Response getResponse() {
        Connection connection = null; // Jsoup.connect(this.wikiPageUrl).timeout(10000);
        Connection.Response resp = null;
        for (int i = 0; i < 5; ++i) {
            try {
                this.pageConnection = Jsoup.connect(this.wikiPageUrl).timeout(1000000);
//                Connection.Response resp = connection.execute();
//                return resp;
                resp = this.pageConnection.execute();
                break;
            } catch (java.io.IOException ioe) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ine) {
                    continue;
                }
            }
        }
        this.pageResponse = resp;
        return resp;
        // TODO: в коде вызова этой функции проверка на нулл
    }
}
