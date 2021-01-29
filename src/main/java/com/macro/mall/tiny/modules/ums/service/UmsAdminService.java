package com.macro.mall.tiny.modules.ums.service;

import com.macro.mall.tiny.modules.ums.dto.UmsAdminParam;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author yangyonglong
 * @since 2021-01-08
 */
public interface UmsAdminService extends IService<UmsAdmin> {

	UmsAdmin register(UmsAdminParam umsAdminParam);

	void index();
}
