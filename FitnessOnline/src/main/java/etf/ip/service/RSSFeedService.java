package etf.ip.service;

import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.rometools.rome.io.XmlReader;

import etf.ip.model.News;

import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class RSSFeedService {
	
	public List<News> getRssFeed(String feedUrl) {
        List<News> news = new ArrayList<>();
         
        try {
            URL url = new URL(feedUrl);
            
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed syndFeed = input.build(new XmlReader(url));

            for (SyndEntry entry : syndFeed.getEntries()) {
                news.add(new News(
                					entry.getTitle(), 
                					getImageUrl(entry), 
                					entry.getDescription().getValue(), 
                					entry.getLink()
                				  ) 
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return news;
    }
	
	
	private String getImageUrl(SyndEntry entry) {
		List<SyndContent> contents = entry.getContents();
        StringBuilder fullContent = new StringBuilder();
        
        for (SyndContent content : contents) {
            fullContent.append(content.getValue());
        }

        int startIndex = fullContent.indexOf("<image>");
        int endIndex = fullContent.indexOf("</image>", startIndex);
        
        if (startIndex != -1 && endIndex != -1) {
            return fullContent.substring(startIndex + 7, endIndex);
        }
        
        return null;
    }
	
}
