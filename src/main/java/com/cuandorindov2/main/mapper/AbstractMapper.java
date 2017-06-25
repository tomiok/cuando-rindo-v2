package com.cuandorindov2.main.mapper;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public interface AbstractMapper<IN, OUT> {

    OUT map(IN objectIn);
}
