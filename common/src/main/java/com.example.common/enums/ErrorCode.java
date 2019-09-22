package com.example.common.enums;

/**
 * ***************************
 * 类说明
 * ***************************
 *
 * @author: qgx
 * @date: 2019-09-22 15:11
 */
public enum ErrorCode {

    /**
     * 成功状态
     */
    SUCCESS("0","success");

    private String code;

    private String errMsg;

    ErrorCode(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static String getMsg(String code){
        for (ErrorCode c:ErrorCode.values()) {
            if (c.getCode().equals(code)) {
                return c.getErrMsg();
            }
        }
        return null;
    }
}
