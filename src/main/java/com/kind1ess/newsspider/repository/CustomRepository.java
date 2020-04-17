package com.kind1ess.newsspider.repository;

import com.kind1ess.newsspider.entity.News;

import java.util.List;

public interface CustomRepository {

    News findByUrl(String url);
}
