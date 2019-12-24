package xyz.ruankun.laughingspork.controller;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.entity.SxReport;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxReportService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.DateUtil;
import xyz.ruankun.laughingspork.util.EntityUtil;
import xyz.ruankun.laughingspork.util.constant.RoleCode;
import xyz.ruankun.laughingspork.vo.ResponseVO;

@RestController
@CrossOrigin
@RequestMapping("/student2")
@Api(tags = {"学生操作2"})
public class StudentController2 {

    private static final Logger logger = LoggerFactory.getLogger(StudentController2.class);

    @Autowired
    SxReportService sxReportService;

    @ApiOperation(value = "更新实习开始结束", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gmtStart", value = "实习开始时间", required = true),
            @ApiImplicitParam(name = "gmtEnd", value = "实习结束时间", required = true)
    })
    @PostMapping("/report/date")
    @RequiresRoles(RoleCode.STUDENT)
    public ResponseVO bindSxDate(@RequestParam(required = true) String gmtStart,@RequestParam(required = true) String gmtEnd){
        boolean dateInputError = gmtEnd == null || gmtStart == null || gmtEnd.equals("") || gmtStart.equals("");
        boolean parseError = DateUtil.getDateByStr(gmtStart) == null || DateUtil.getDateByStr(gmtEnd) == null;
        if (dateInputError){
            return ControllerUtil.getFalseResultMsgBySelf("请传入时间gmtStart 和 gmtEnd");
        }else if(parseError){
            return ControllerUtil.getFalseResultMsgBySelf("时间格式错误,正确的时间格式:2020-11-21 12:12:12(时分秒可省略)");
        }

        SxStudent sxStudent = (SxStudent) SecurityUtils.getSubject().getPrincipal();
        SxReport sxReport = sxReportService.getReportInfo(sxStudent.getStuNo());
        if (sxReport == null){
            return ControllerUtil.getFalseResultMsgBySelf("查询实习报告时出现错误！请查看后台日志");
        }
        SxReport sxReportFromFront = new SxReport();
        sxReportFromFront.setGmtEnd(DateUtil.getSqlDateByStr(gmtEnd));
        sxReportFromFront.setGmtStart(DateUtil.getSqlDateByStr(gmtStart));
        EntityUtil.update(sxReportFromFront,sxReport);
        logger.info("sxReport未更新前: " + sxReport.toString());
        logger.info("sxReport实习开始结束时间即将被更新: " + sxReportFromFront.toString());
        try {
            sxReportService.saveReport(sxReportFromFront);
            return ControllerUtil.getSuccessResultBySelf("更新成功");
        }catch (Exception e){
            return ControllerUtil.getFalseResultMsgBySelf("更新失败：" + e.getMessage());
        }
    }
}
