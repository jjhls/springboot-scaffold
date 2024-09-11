package com.thinktech.service;

import com.thinktech.entity.SysOrg;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统组织结构表 服务类
 * </p>
 *
 * @author hls
 * @since 2024-08-23
 */
public interface ISysOrgService extends IService<SysOrg> {

    void update(SysOrg sysOrg);
}
