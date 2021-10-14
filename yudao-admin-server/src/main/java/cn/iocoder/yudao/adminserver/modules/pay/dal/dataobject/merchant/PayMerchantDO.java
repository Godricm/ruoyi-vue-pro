package cn.iocoder.yudao.adminserver.modules.pay.dal.dataobject.merchant;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 商户信息 DO
 * 目前暂时没有特别的用途，主要为未来多商户提供基础。
 *
 * @author 芋道源码
 */
@Data
public class PayMerchantDO extends BaseDO {

    /**
     * 商户编号，数据库自增
     */
    @TableId
    private Long id;
    /**
     * 商户号
     * 例如说，M233666999
     */
    private String no;
    /**
     * 商户全称
     */
    private String name;
    /**
     * 商户简称
     */
    private String shortName;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
