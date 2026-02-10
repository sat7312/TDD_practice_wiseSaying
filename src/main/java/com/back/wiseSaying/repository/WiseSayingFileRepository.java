package com.back.wiseSaying.repository;

import com.back.standard.util.Util;
import com.back.wiseSaying.entity.WiseSaying;

import java.util.Map;

public class WiseSayingFileRepository {

    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {

        if (wiseSaying.isNew()) {

            wiseSaying.setId(++lastId);
            Map<String, Object> wiseSayingMap = wiseSaying.toMap();
            String jsonStr = Util.json.toString(wiseSayingMap);

            Util.file.set("db/wiseSaying/%d.json".formatted(wiseSaying.getId()), jsonStr);
        }

        return wiseSaying;
    }

    public WiseSaying findByIdOrNull(int id) {
        String jsonStr = Util.file.get("db/wiseSaying/%d.json".formatted(id), "");

        if (jsonStr.isBlank()) {
            return null;
        }

        Map<String, Object> map = Util.json.toMap(jsonStr);
        return WiseSaying.fromMap(map);
    }
}