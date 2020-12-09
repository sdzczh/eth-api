package com.zh.eth.controller;


import com.alibaba.fastjson.JSONObject;
import com.zh.eth.domain.Coin;
import com.zh.eth.domain.PayConfig;
import com.zh.eth.domain.PayList;
import com.zh.eth.domain.Users;
import com.zh.eth.dto.AjaxResult;
import com.zh.eth.service.ICoinService;
import com.zh.eth.service.IPayConfigService;
import com.zh.eth.service.IPayListService;
import com.zh.eth.service.IUsersService;
import com.zh.eth.utils.HttpUtils;
import com.zh.eth.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/main")
public class IndexController {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private ICoinService coinService;
    @Autowired
    private IPayConfigService payConfigService;
    @Autowired
    private IPayListService payListService;

    /**
     * 主页初始化
     * @param request
     * @return
     * @throws ParseException
     */
    @GetMapping("/init")
    @ResponseBody
    public AjaxResult init(HttpServletRequest request) throws ParseException {
        Object token1 = request.getHeader("token");
        String token = token1 == null ? "" : token1.toString();
        if(StringUtils.isNotEmpty(token)){
            Users users = usersService.selectByToken(token);
            if(users == null){
                return AjaxResult.error("用户不存在，请重新登录");
            }
        }else {
            return AjaxResult.error("用户登录信息失效，请重新登录");
        }
        JSONObject jsonObject = new JSONObject();
        PayConfig payConfig = payConfigService.selectPayConfigById((long) 1);
        Long coinId = payConfig.getCoinId();
        Coin coin = coinService.selectCoinById(coinId);
        jsonObject.put("address", "address");
        jsonObject.put("days", payConfig.getNumbersTime());
        jsonObject.put("coin", coin.getCoinName());
        jsonObject.put("rules", payConfig.getRules());
        jsonObject.put("infos", payConfig.getInfos());
        jsonObject.put("times", com.ruoyi.common.utils.DateUtils.dateToStamp(payConfig.getEndTime()));
        return AjaxResult.success(jsonObject);
    }
    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(HttpServletRequest request) throws ParseException {
        Object token1 = request.getHeader("token");
        String token = token1 == null ? "" : token1.toString();
        List<Map<String, Object>> list = new LinkedList<>();
        if(StringUtils.isNotEmpty(token)){
            Users users = usersService.selectByToken(token);
            if(users == null){
                return AjaxResult.error("用户不存在，请重新登录");
            }
            PayList payList = new PayList();
            payList.setUserId(users.getId());
            List<PayList> payLists = payListService.selectPayListList(payList);
            for (PayList payList1 : payLists) {
                Map<String, Object> map = new HashMap<>();
                Coin coin = coinService.selectCoinById(payList1.getToCoin());
                map.put("amount", payList1.getToAmount().setScale(2, BigDecimal.ROUND_HALF_UP) + " " + coin.getCoinName());
                String status;
                switch (payList1.getStatus()){
                    case 0 : status = "未处理";break;
                    case 1 : status = "成功";break;
                    case 2 : status = "驳回";break;
                    default: status = "未处理";break;
                }
                map.put("status", status);
                map.put("date", payList1.getCreateTime());
                list.add(map);
            }
        }else {
            return AjaxResult.error("用户登录信息失效，请重新登录");
        }
        return AjaxResult.success(list);
    }

    /**
     * 获取联系客服二维码
     * @return
     */
    @GetMapping("/contact")
    @ResponseBody
    public AjaxResult contact(){
        return AjaxResult.success("https://img-blog.csdnimg.cn/20201203184614188.jpg");
    }
    /**
     * 提交认购
     * @return
     */
    @PostMapping("/commit")
    @ResponseBody
    public AjaxResult commit(HttpServletRequest request, String address, String amount){
        PayConfig payConfig = payConfigService.selectPayConfigById((long) 1);
        if(!com.ruoyi.common.utils.DateUtils.compareDate(com.ruoyi.common.utils.DateUtils.getTime(), payConfig.getStartTime())){
            return AjaxResult.error("认购还没开始");
        }
        if(com.ruoyi.common.utils.DateUtils.compareDate(com.ruoyi.common.utils.DateUtils.getTime(), payConfig.getEndTime())){
            return AjaxResult.error("认购已经结束");
        }
        Object token1 = request.getHeader("token");
        String token = token1 == null ? "" : token1.toString();
        List<Map<String, Object>> list = new LinkedList<>();
        if(StringUtils.isNotEmpty(token)) {
            Users users = usersService.selectByToken(token);
            if (users == null) {
                return AjaxResult.error("用户不存在，请重新登录");
            }
            PayList payList = new PayList();
            payList.setUserId(users.getId());
            payList.setAddress(address);
            payList.setAmount(new BigDecimal(amount));
            payList.setCoinId(payConfig.getCoinId());
            payList.setCreateTime(com.ruoyi.common.utils.DateUtils.getTime());
            payList.setpId(payConfig.getId());
            payList.setStatus(0);
            String result = HttpUtils.sendGet("https://api.coinbase.com/v2/prices/ETH-CNY/buy", "");
            if(StringUtils.isNotEmpty(result)){
                String price = com.alibaba.fastjson.JSONObject.parseObject(result).getJSONObject("data").getString("amount");
                BigDecimal ethPrice = new BigDecimal(price);
                BigDecimal toAmoount = new BigDecimal(amount).multiply(ethPrice).divide(new BigDecimal(payConfig.getProportion()).setScale(4, BigDecimal.ROUND_HALF_UP));
                payList.setToAmount(toAmoount);
                payList.setToCoin(payConfig.getToCoin());
                payListService.insertPayList(payList);
                return AjaxResult.success();
            }else {
                return AjaxResult.error("获取最新ETH价格失败，请稍后重试");
            }
        }else {
            return AjaxResult.error("用户登录信息失效，请重新登录");
        }
    }

}
