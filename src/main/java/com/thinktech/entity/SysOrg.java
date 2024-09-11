package com.thinktech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统组织结构表
 * </p>
 *
 * @author hls
 * @since 2024-08-23
 */
@Getter
@Setter
@TableName("sys_org")
public class SysOrg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上级组织编码
     */
    private Integer orgPid;

    /**
     * 所有的父节点id
     */
    private String orgPids;

    /**
     * 0:不是叶子节点，1:是叶子节点
     */
    private Byte isLeaf;

    /**
     * 组织名
     */
    private String orgName;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮件
     */
    private String email;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 组织层级
     */
    private Byte level;

    /**
     * 0:启用,1:禁用
     */
    private Byte status;
}
