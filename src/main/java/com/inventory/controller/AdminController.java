package com.inventory.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inventory.constants.SwaggerConstants.AdminConstant.BASE_API_VALUE;
import static com.inventory.constants.WebResourceKeyConstants.API_V1;
import static com.inventory.constants.WebResourceKeyConstants.AdminConstant.BASE_ADMIN;

/**
 * @author rupak ON 2020/07/21-8:39 AM
 */
@RestController
@RequestMapping(value = API_V1 +BASE_ADMIN)
@Api(BASE_API_VALUE)
public class AdminController {
}
