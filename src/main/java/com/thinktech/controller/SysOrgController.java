package com.thinktech.controller;

import com.thinktech.entity.SysOrg;
import com.thinktech.service.ISysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统组织结构表 前端控制器
 * </p>
 *
 * @author hls
 * @since 2024-08-23
 */
@RestController
@RequestMapping("/sysOrg")
public class SysOrgController {

    @Autowired
    private ISysOrgService sysOrgService;

    @PostMapping("/update")
    public void add(SysOrg sysOrg) {
        sysOrgService.update(sysOrg);
    }

    @GetMapping("/show")
    public List<SysOrg> show() {
        return null;
    }

}
