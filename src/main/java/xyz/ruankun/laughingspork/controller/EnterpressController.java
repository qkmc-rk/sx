package xyz.ruankun.laughingspork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.entity.SxCorporation;
import xyz.ruankun.laughingspork.service.SxCorporationService;
import xyz.ruankun.laughingspork.strategy.Enterprise;
import xyz.ruankun.laughingspork.strategy.EnterpriseContext;
import xyz.ruankun.laughingspork.strategy.impl.Qichacha;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

@RestController
@RequestMapping("/enterprise")
@Api(tags = {"企业信息接口"})
@CrossOrigin
public class EnterpressController {

    public static final Logger logger = LoggerFactory.getLogger(EnterpressController.class);

    @Autowired
    SxCorporationService sxCorporationService;

    @ApiOperation(value = "校验企业信息", httpMethod = "GET")
    @GetMapping("/verification/{stuNo}")
    public ResponseVO authEnterpriseInfo(@PathVariable String stuNo) {
        SxCorporation sxCorporation = sxCorporationService.findByStuNo(stuNo);
        if (sxCorporation != null) {
            Enterprise enterprise = new Enterprise(sxCorporation.getCorpName(),
                    sxCorporation.getCreditCode(), sxCorporation.getLegalPerson());
            EnterpriseContext enterpriseContext = new EnterpriseContext(new Qichacha());
            String result = enterpriseContext.authEnterprise(enterprise);
            if (result != null) {
                return ControllerUtil.getSuccessResultBySelf(result);
            }
        } else {
            return ControllerUtil.getFalseResultMsgBySelf("学号错误或该学生未绑定企业信息");
        }
        return ControllerUtil.getFalseResultMsgBySelf("查询失败");
    }
}
