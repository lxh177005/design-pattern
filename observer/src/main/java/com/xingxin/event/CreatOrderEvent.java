package com.xingxin.event;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatOrderEvent {
    private JSONObject jsonObject;
}
