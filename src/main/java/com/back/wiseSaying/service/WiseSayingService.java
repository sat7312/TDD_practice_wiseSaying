package com.back.wiseSaying.service;

import com.back.wiseSaying.entity.WiseSaying;
import com.back.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayingRepository.findListDesc();
    }
}