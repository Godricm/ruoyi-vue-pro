package cn.iocoder.yudao.module.promotion.controller.app.coupon;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon.AppCouponPageReqVO;
import cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.coupon.AppCouponRespVO;
import cn.iocoder.yudao.module.promotion.controller.app.coupon.vo.template.AppCouponTemplatePageReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "用户 App - 优惠劵")
@RestController
@RequestMapping("/promotion/coupon")
@Validated
public class AppCouponController {

    // TODO 芋艿：待实现
    @PostMapping("/take")
    @Operation(summary = "领取优惠劵")
    public CommonResult<Long> takeCoupon(@RequestBody AppCouponTemplatePageReqVO pageReqVO) {
        return success(1L);
    }

    // TODO 芋艿：待实现
    @GetMapping("/page")
    @Operation(summary = "优惠劵列表", description = "我的优惠劵")
    public CommonResult<PageResult<AppCouponRespVO>> takeCoupon(AppCouponPageReqVO pageReqVO) {
        List<AppCouponRespVO> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            AppCouponRespVO vo = new AppCouponRespVO();
            vo.setId(i + 1L);
            vo.setName("优惠劵" + (i + 1));
            vo.setStatus(pageReqVO.getStatus());
            vo.setUsePrice(random.nextInt(100) * 100);
            vo.setValidStartTime(LocalDateTime.now().plusDays(random.nextInt(10)));
            vo.setValidEndTime(LocalDateTime.now().plusDays(random.nextInt(20) + 10));
            vo.setDiscountType(random.nextInt(2) + 1);
            if (vo.getDiscountType() == 1) {
                vo.setDiscountPercent(null);
                vo.setDiscountPrice(random.nextInt(50) * 100);
                vo.setDiscountLimitPrice(null);
            } else {
                vo.setDiscountPercent(random.nextInt(90) + 10);
                vo.setDiscountPrice(null);
                vo.setDiscountLimitPrice(random.nextInt(200) * 100);
            }
            list.add(vo);
        }
        return success(new PageResult<>(list, 20L));
    }

}
