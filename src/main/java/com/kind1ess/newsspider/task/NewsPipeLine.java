package com.kind1ess.newsspider.task;

import com.kind1ess.newsspider.entity.News;
import com.kind1ess.newsspider.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class NewsPipeLine implements Pipeline {

    @Autowired
    private NewsService newsService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        News news = resultItems.get("news");
        if (news!=null){
            newsService.saveNews(news);
//            System.out.println("+++++++++++++++++++++++"+news.getUrl()+"++++++++++++++++++++++");
        }
    }
}
