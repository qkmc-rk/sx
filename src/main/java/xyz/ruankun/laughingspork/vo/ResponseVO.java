package xyz.ruankun.laughingspork.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.ruankun.laughingspork.util.constant.RespCode;

import java.util.Date;

public class ResponseVO<T> {


    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;
    @JsonProperty("timestamp")
    private Date timestamp = new Date();

    public void success(T data) {
        this.status = RespCode.SUCCESS_CODE;
        this.message = RespCode.MSG_SUCCESS;
        this.data = data;
    }

    public void serverError() {
        this.status = RespCode.FAILURE_CODE;
        this.message = RespCode.MSG_SERVER_ERROR;
    }

    public void clientError() {
        this.status = RespCode.FAILURE_CODE;
        this.message = RespCode.MSG_CLIENT_DATA_ERROR;
    }

    /**
     * 自定义错误状态
     *
     * @param status  错误码
     * @param message 错误信息
     * @param data    错误时的数据
     */
    public void error(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 自定义成功状态
     *
     * @param status  成功代码
     * @param message 成功信息
     * @param data    成功时的数据
     */
    public void success(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
