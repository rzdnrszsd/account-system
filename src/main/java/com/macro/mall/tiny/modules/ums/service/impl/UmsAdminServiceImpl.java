package com.macro.mall.tiny.modules.ums.service.impl;

import com.macro.mall.tiny.common.service.RedisService;
import com.macro.mall.tiny.modules.ums.dto.UmsAdminParam;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.mapper.UmsAdminMapper;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author yangyonglong
 * @since 2021-01-08
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

	@Resource
	private RedisService redisService;

//	@Autowired
//	private PasswordEncoder passwordEncoder;


	@Override
	public UmsAdmin register(UmsAdminParam umsAdminParam) {
		return null;
	}

	@Override
	public void index() {
		redisService.set("ums:aa","32");
	}
}
