package com.kind1ess.newsspider.task;

import com.kind1ess.newsspider.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;

@Component
public class NewsPageProcessor implements PageProcessor {

    private static Integer i = 1;


    @Autowired
    private NewsPipeLine newsPipeLine;

    @Scheduled(initialDelay = 1000, fixedDelay = 100 * 1000)
    public void process(){
        Request request = new Request("https://interface.sina.cn/news/get_news_by_channel_new_v2018.d.html?cat_1=51923&show_num=100&page="+i+++"&_=1586943208884");
        request.setMethod(HttpConstant.Method.POST);
        Spider.create(new NewsPageProcessor())
                .addRequest(request)
                .thread(10)
                .addPipeline(newsPipeLine)
                .run();
    }

    @Override
    public void process(Page page) {
        if (page.getUrl().regex("page").match()){
            //返回结果为json
            List<String> jsonUrlList = new JsonPathSelector("$.result.data[*].url").selectList(page.getRawText());
            for (String jsonUrl : jsonUrlList) {
                page.addTargetRequest(jsonUrl);
            }
        }else {
            String html1 = page.getHtml().toString();
            Html html = page.getHtml();
            List<Selectable> list = html.css("div#subShowContent1_static div.news-item h2 a").nodes();
            if (list.isEmpty()){
                //详情页解析页面
                processPage(page);
            }else{
                for (Selectable selectable : list) {
                    String detailUrl = selectable.links().toString();
                    System.out.println("url:"+detailUrl);
                    page.addTargetRequest(detailUrl);
                }
            }
        }
    }

    public void processPage(Page page){
        News news = new News();
        Html html = page.getHtml();
        String title = html.css("div.main-content h1.main-title","text").toString();
        String time = html.css("div#top_bar_wrap div#top_bar div.top-bar-inner div.date-source span","text").toString();
        String source = html.css("div#top_bar_wrap div#top_bar div.top-bar-inner div.date-source a","text").toString();
        String keyword = html.css("div#article-bottom div#keywords a","text").toString();
        String content = html.css("div#article p","text").all().toString();
        String author = null;
        if (html.css("div#article p","text").nodes().size()>0){
            author = html.css("div#article p","text").nodes().get(html.css("div#article p","text").nodes().size()-1).toString();
        }
        String url = page.getUrl().toString();
        news.setAuthor(author);
        news.setContent(content);
        news.setKeyWord(keyword);
        news.setSource(source);
        news.setTime(time);
        news.setTitle(title);
        news.setUrl(url);
        page.putField("news",news);
    }
    private Site site = Site.me()
            .setCharset("UTF-8")
            .setTimeOut(10*1000)
            .setRetryTimes(3)
            .setRetrySleepTime(3000);
    @Override
    public Site getSite() {
        return site;
    }
}
