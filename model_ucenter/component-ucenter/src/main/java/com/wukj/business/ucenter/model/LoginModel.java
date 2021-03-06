package com.wukj.business.ucenter.model;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;
import com.wukj.business.ucenter.R;
import com.wukj.business.net.entity.request.LoginRequest;
import com.wukj.business.net.CommonModel;
import com.wukj.utils.StringUtils;
import com.wukj.utils.VerifyUtils;

/**
 * 项目名称：NetCar_Chauffeur
 * 包名称：com.wukj.business.ucenter.model.
 * 创建时间：2018/8/7 9:26
 * 作者：Jonyker
 * 博客：https://www.jianshu.com/u/07642698e7f4
 * github：https://github.com/Jonyker
 * 修改人：Jonyker
 * 联系方式：QQ/534098845
 * 修改时间：2018/8/7 9:26
 * 备注：
 * 版本：V.1.0
 * 描述：
 */
public class LoginModel extends CommonModel{


    /**
     * 验证请求参数
     * @param request
     * @return
     */
    public boolean getVerifyParameterable(Context context,LoginRequest request){
        if(StringUtils.isEmpty(request.getAccount())){
            ToastUtils.showShort(context.getString(R.string.mobile_not_empty));
            return false;
        }
        if(StringUtils.isEmpty(request.getPassword())){
            ToastUtils.showShort(context.getString(R.string.passwprd_not_empty));
            return false;
        }
        if(!VerifyUtils.isMobile(request.getAccount())){
            ToastUtils.showShort(context.getString(R.string.mobile_not_lawful));
            return false;
        }
        if(request.getPassword().length()<6){
            ToastUtils.showShort(context.getString(R.string.passwprd_not_lawful_6));
            return false;
        }
        return true;
    }


}
