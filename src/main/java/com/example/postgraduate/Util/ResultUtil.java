package com.example.postgraduate.Util;

import com.example.postgraduate.POJO.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result Result=new Result();
        Result.setCode(200);
        Result.setMsg("请求成功");
        Result.setData(object);
        return Result;
    }
    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String resultResult){
        Result Result=new Result();
        Result.setCode(code);
        Result.setMsg(resultResult);
        return Result;
    }
}
