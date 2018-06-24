package com.yundian.fss.pay.withhold.haier;

/**
 * 快捷通公用返回CODE
 *
 * @author jnx
 * @create 2018/6/22
 */
public enum HaierStatusCode {
    S10000("接口调用成功"),
    F20000("服务不可用");

/*其他待添加*/

    private String description;

    HaierStatusCode(String desc)
    {
        this.description = desc;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
