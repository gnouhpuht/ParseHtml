package com.t3h.parsehtml;

import com.t3h.parsehtml.model.MotherChildModel;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class CommonCrawl {

    public static void getData(String link,
                                                 List<MotherChildModel> mcs,
                                                 String content){
        try {
            Connection conn =
                    Jsoup.connect(link);
            Document doc =conn.get();
//            Element scroll =
//                    doc.getElementsByClass("scrollC").first();
            Elements elements =
                    doc.getElementsByClass(content);
            for (Element element : elements) {
                Elements es = element.select("p");
                String conent = es.text();
                String title = element.select("h3").text();
                String linkImage = es.select("img").first()
                        .attr("data-src");
                String linkDetail = element.select("a")
                        .attr("href");
                mcs.add(
                        new MotherChildModel(title, conent,
                                linkImage, linkDetail));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
