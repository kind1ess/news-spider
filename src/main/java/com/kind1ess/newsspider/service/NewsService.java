package com.kind1ess.newsspider.service;

import com.kind1ess.newsspider.entity.News;

public interface NewsService {

    void saveNews(News news);

    boolean isExist(String url);
}
