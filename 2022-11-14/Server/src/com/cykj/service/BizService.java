package com.cykj.service;

import com.alibaba.fastjson.JSONObject;
import com.cykj.Thread.ServerRec;

public interface BizService {
    void doService(JSONObject jsonObject, ServerRec serverRec);
}
