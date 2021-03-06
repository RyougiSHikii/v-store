package store.online.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.online.entity.AdvertDetail;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@FeignClient(name = "STORE-ONLINE-SERVICE/advertDetailService")
public interface IAdvertDetailService {

    @PostMapping("/insertAdvertDetail")
    Integer insertAdvertDetail(@RequestBody AdvertDetail advertDetail,
                               @RequestParam("userName") String userName);

    /**
     * 根据广告位ID查找显示广告列表
     * param advertId 广告位ID
     * return
     */
    @PostMapping("/listByAdvertId")
    List<AdvertDetail> listByAdvertId(@RequestParam("advertId") Long advertId);

    /**
     * 根据广告ID/分页信息/搜索内容查找导航列表
     * param advertId 广告ID
     * param pageInfo 分页信息
     * param search 搜索内容
     * return
     */
    @PostMapping("/listByPage")
    BasePageDTO<AdvertDetail> listByPage(@RequestParam("advertId") Long advertId,
                                         @RequestBody PageInfo pageInfo,
                                         @RequestParam("search") String search);

    /**
     * 更新广告详情状态
     * param advertDetailId 广告详情ID
     * return
     */
    @PostMapping("/updateStatus")
    Integer updateStatus(@RequestParam("advertDetailId") Long advertDetailId);

    /**
     * 更新广告详情信息
     * param advertDetail 广告详情信息
     * param userName 操作人
     * return
     */
    @PostMapping("/updateNavigationBar")
    Integer updateNavigationBar(@RequestParam("advertDetail") AdvertDetail advertDetail,
                                @RequestParam("userName") String userName);

    /**
     * 根据广告详情ID删除广告详情,同时更新广告位数量
     * param advertDetailId 广告详情ID
     * return
     */
    @PostMapping("/deleteByAdvertDetailId")
    Integer deleteByAdvertDetailId(@RequestParam("advertDetailId") Long advertDetailId);
}
