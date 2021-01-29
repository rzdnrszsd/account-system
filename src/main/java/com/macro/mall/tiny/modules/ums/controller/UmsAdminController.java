package com.macro.mall.tiny.modules.ums.controller;


import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.ums.dto.UmsAdminParam;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author yangyonglong
 * @since 2021-01-08
 */
@RestController
@RequestMapping("/admin")
@Api("用户后台管理")
public class UmsAdminController {

	@Autowired
	private UmsAdminService adminService;


	@RequestMapping("/index")
	public String index(){
		adminService.index();
		return "ds";
	}

	@RequestMapping("/register")
	@ApiOperation("注册")
	public CommonResult<UmsAdmin> register(@RequestBody @Validated UmsAdminParam umsAdminParam){
		UmsAdmin umsAdmin = adminService.register(umsAdminParam);
		if (umsAdmin == null) {
			return CommonResult.failed();
		}
		return CommonResult.success(umsAdmin);
	}
}

