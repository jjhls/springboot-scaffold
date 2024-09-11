package com.thinktech.service.impl;

import com.thinktech.entity.SysOrg;
import com.thinktech.mapper.SysOrgMapper;
import com.thinktech.service.ISysOrgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统组织结构表 服务实现类
 * </p>
 *
 * @author hls
 * @since 2024-08-23
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements ISysOrgService {

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Override
    public void update(SysOrg sysOrg) {
        if(sysOrg.getId()!=null){
            sysOrgMapper.updateById(sysOrg);
        }else{
            sysOrgMapper.insert(sysOrg);
        }
    }
}
