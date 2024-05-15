package etf.ip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etf.ip.model.News;
import etf.ip.service.RSSFeedService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class RSSFeedController {
		
	@Autowired
    private final RSSFeedService rssFeedService;

    @Autowired
    public RSSFeedController(RSSFeedService rssFeedService) {
        this.rssFeedService = rssFeedService;
    }

    
    @GetMapping("/rss-feed")
    public List<News> getRssFeed() {
        // String feedUrl = "https://feeds.feedburner.com/feed";
         String feedUrl = "https://feeds.feedburner.com/AceFitFacts";
        return rssFeedService.getRssFeed(feedUrl);
    }
	
}
