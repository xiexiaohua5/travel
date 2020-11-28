package com.qf.travel.commons.exception;


import com.qf.travel.commons.result.ResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceException extends RuntimeException{
    private int code;
    private String meg;
    private String tips;

    public ServiceException(ResultCodeEnum codeEnum){
        this.code = codeEnum.getRetCode();
        this.meg = codeEnum.getRetMsg();
        this.tips = codeEnum.getTips();
    }
}

