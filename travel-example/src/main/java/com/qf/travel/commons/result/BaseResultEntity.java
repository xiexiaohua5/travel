package com.qf.travel.commons.result;

import lombok.Data;

/**
 * 返回结果封装类
 */
@Data
public class BaseResultEntity<T> {
    /**
     * 返回码
     */
    private int retCode;
    /**
     * 返回说明
     */
    private String retMsg;
    /**
     * 提示
     */
    private String tips;
    /**
     * 返回数据
     */
    private T info;

    public BaseResultEntity(){
    }

    public BaseResultEntity(T info){
        /*这个this是干嘛的,暂时还不知道是干嘛的*/
        this();
        this.info = info;
    }

    public BaseResultEntity(ResultCodeEnum codeEnum, T info){
        this.retCode = codeEnum.retCode;
        this.retMsg = codeEnum.retMsg;
        this.tips = codeEnum.tips;
        this.info = info;
    }

    public BaseResultEntity(ResultCodeEnum codeEnum){
        this.retCode = codeEnum.retCode;
        this.retMsg = codeEnum.retMsg;
        this.tips = codeEnum.retMsg;
    }

    public BaseResultEntity(int code, String meg, String tips){
        this.retCode = code;
        this.retMsg = meg;
        this.tips = tips;
    }

    /**
     * 调用另一个成功的方法,做一个统一的成功的提示，
     * 在参数里面就不需要再传入枚举的提示语，
     * 避免了一些多余代码
     * @param info
     * @param <T>
     * @return
     */
    public static <T> BaseResultEntity<T> success(T info){
        return success(ResultCodeEnum.SUCCESS,info);
    }

    /**
     * 被调用的成功的方法
     * @param codeEnum
     * @param info
     * @param <T>
     * @return
     */
    public static <T> BaseResultEntity<T> success(ResultCodeEnum codeEnum, T info){
        return new BaseResultEntity<>(codeEnum,info);
    }

    /**
     * 返回的是一个统一的错误提示，不需要再传错误提示
     * @param <T>
     * @return
     */
    public static <T> BaseResultEntity<T> error(){
        return new BaseResultEntity<>(ResultCodeEnum.ERROR);
    }

    /**
     * 当最后的结果为空时，只需传入一个错误提示，
     * null已经在这里设置好，避免了多余的代码
     * @param codeEnum
     * @param <T>
     * @return
     */
    public static <T> BaseResultEntity<T> error(ResultCodeEnum codeEnum){
        return error(codeEnum, null);
    }

    /**
     * 被调用的错误的方法
     * @param codeEnum
     * @param data
     * @param <T>
     * @return
     */
    private static <T> BaseResultEntity<T> error(ResultCodeEnum codeEnum, T data) {
        return new BaseResultEntity<>(codeEnum, data);
    }

    /**
     * 暂时还不知道是干嘛的
     * @param traceId
     * @param retCode
     * @param retMsg
     * @param <T>
     * @return
     */
    public static <T> BaseResultEntity<T> error(String traceId, int retCode, String retMsg){
        BaseResultEntity<T> entity = new BaseResultEntity<>();
        entity.setRetCode(retCode);
        entity.setRetMsg(retMsg);
        return entity;
    }

    /**
     * 专门给全局异常的但又不是通用的异常
     * @param code
     * @param meg
     * @param tips
     * @param <T>
     * @return
     */
    public static <T> BaseResultEntity<T> error(int code, String meg, String tips){
        return new BaseResultEntity<>(code, meg, tips);
    }

}
