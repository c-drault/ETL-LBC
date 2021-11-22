package fr.cdrault.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.cdrault.service.Extracter;
import fr.cdrault.service.Transformer;
import lombok.Getter;

//Va chercher les information brut sur le site. C'est un crawler.

@Getter
public class CrawlerExtracter implements Extracter{
    private Transformer transformer;

    private Queue<String> queue;
    private List<String> markedUri;
    private int maxResult;
    private String regex = "https://www.theguardian.com/us-news/[/0-9a-z\\-]*";

    public CrawlerExtracter(String startUri, Transformer transformer, int maxResult){
        this.transformer = transformer;
        this.queue = new LinkedList<String>();
        this.markedUri = new ArrayList<String>();
        this.maxResult = maxResult;

        this.queue.add(startUri);
    }

    @Override
    public void extract() throws IOException {
        while(!queue.isEmpty()){
            String crawledURL = queue.poll();

            if(markedUri.size() > maxResult){
                return;
            }

            boolean ok = false;
            URL url = null;
            BufferedReader br = null;

            while(!ok){
                try{
                    url = new URL(crawledURL);
                    br = new BufferedReader(new InputStreamReader(url.openStream()));
                    ok = true;

                }catch(MalformedURLException e){
                    //TODO: AJOUTER DES LOGGER
                    // System.out.println("WARN : malformed website url -> " + crawledURL);
                    crawledURL = queue.poll();
                    ok = false;
                }catch(IOException e){
                    //TODO: AJOUTER DES LOGGER
                    // System.out.println("WARN : IOException for website url -> " + crawledURL);
                    crawledURL = queue.poll();
                    ok = false;
                }
            }

            StringBuilder sb = new StringBuilder();
            String tmp = null;
            while((tmp = br.readLine()) != null){
                sb.append(tmp);
            }

            if(br != null){
                br.close();
            }

            tmp = sb.toString();
            tmp+= "<websiteuri>"+crawledURL+"</websiteuri>";

            transformer.transform(tmp);

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(tmp);

            while(matcher.find()){
                String w = matcher.group();
                if(!markedUri.contains(w) && !queue.contains(w)){
                    //TODO: AJOUTER DES LOGGER
                    // System.out.println("Site added for crawling : " + w);
                    this.queue.add(w);
                }
            }
            markedUri.add(crawledURL);
        }
        
    }
    
}
