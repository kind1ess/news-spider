package com.kind1ess.newsspider.jsontest;


import org.springframework.boot.test.context.SpringBootTest;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;

@SpringBootTest
public class JsonResponseTest implements PageProcessor {

    private static Integer i = 4;
    @Override
    public void process(Page page) {
        System.out.println(page.getUrl().regex("www").match());
        List<String> list = new JsonPathSelector("$.result.data[*].url").selectList(page.getRawText());
        System.out.println();
    }

    private Site site = Site.me()
            .setCharset("UTF-8");
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Request request = new Request("https://interface.sina.cn/news/get_news_by_channel_new_v2018.d.html?cat_1=51923&show_num=100&page="+i+++"&_=1586943208884");
        request.setMethod(HttpConstant.Method.POST);
        Spider.create(new JsonResponseTest())
                .addRequest(request)
                .run();
    }
}
