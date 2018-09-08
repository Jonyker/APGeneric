package com.jonyker.common.net.common;

import com.jonyker.entity.BaseResponseEntity;

/**
 * 项目名称：NetCar_Chauffeur
 * 包名称：com.jonyker.mvp.model.listener.
 * 创建时间：2018/8/7 9:21
 * 作者：Jonyker
 * 博客：http://blog.csdn.net/jerry_137188
 * github：https://github.com/Jiitech
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/8/7 9:21
 * 备注：
 * 版本：V.1.0
 * 描述：
 */
public interface BaseDataObserver<RES extends BaseResponseEntity> {

    /**
     * 成功回调
     * @param res
     */
    void onSuccess(RES res);

    /**
     * 失败回调
     * @param error_msg
     */
    void onFailure(String error_msg);

}