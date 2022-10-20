package com.lyk.ftgson.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lianyongke on 2018/3/19.
 */

public class TestBean implements Serializable {

    private String resultCode;
    private String reason;
    private List<ResultBean> result;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "FlechBean{" +
                "\n\nresultCode='" + resultCode + '\'' +
                "\n\n, reason='" + reason + '\'' +
                "\n\n, result=" + result +
                '}';
    }

}
