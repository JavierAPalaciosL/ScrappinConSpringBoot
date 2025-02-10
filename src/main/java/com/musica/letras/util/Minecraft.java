package com.musica.letras.util;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Getter
@Setter
public class Minecraft {

    private String artist;
    private String title;
    private String url;

    public Minecraft(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public Minecraft() {
        this("", "");
    }

    public String getLetter(){
        this.url = "https://www.letras.com/"+this.artist+"/"+this.title+"/";
        String letter = "";
        try{
            Document doc = Jsoup.connect(url).get();

            Element lyricDiv = doc.selectFirst(".lyric-original");

            if (lyricDiv != null) {
                Elements paragraphs = lyricDiv.select("p");

                StringBuilder lyrics = new StringBuilder();
                for (Element p : paragraphs) {
                    lyrics.append(p.html().replace("<br>", "\n")).append("\n\n");
                }
                letter = lyrics.toString().trim();
            } else {
                letter = "No se encontro la letra";
            }
        } catch (Exception e) {
            letter = "Error al obtener la letra"+ e.getMessage();
        }
        return letter;
    }

}
