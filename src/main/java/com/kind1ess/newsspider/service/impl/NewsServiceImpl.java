package com.kind1ess.newsspider.service.impl;


import com.kind1ess.newsspider.entity.News;
import com.kind1ess.newsspider.repository.NewsRepository;
import com.kind1ess.newsspider.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void saveNews(News news) {
//        if (!isExist(news.getUrl()))
            newsRepository.save(news);
//        else System.out.println("新闻" +news.getTitle()+
//                "已存在！");
    }

    @Override
    public boolean isExist(String url) {
        News news = newsRepository.findByUrl(url);
        if (news == null)
            return false;
        return true;
    }
}
