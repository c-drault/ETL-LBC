package fr.cdrault.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private String title;
    private String author;
    // private String date;
    private String url;
    // private String content;
}
