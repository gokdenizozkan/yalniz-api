package com.gokdenizozkan.yalnizapi.config.response;

import com.gokdenizozkan.yalnizapi.config.datastructure.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Data {
    private final Map<String, Object> data;

    private Data() {
        data = new HashMap<>();
    }

    public static Data of(Pair... pairs) {
        Data data = new Data();
        for (Pair pair : pairs) {
            data.data.put(pair.key, pair.value);
        }
        return data;
    }

    public Map<String, Object> get() {
        return data;
    }

    public <T, V> void map(Function<T, V> mapper) {
        data.replaceAll((k, v) -> mapper.apply((T) v));
    }
}
