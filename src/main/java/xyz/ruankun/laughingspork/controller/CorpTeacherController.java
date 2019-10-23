package xyz.ruankun.laughingspork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ruankun.laughingspork.entity.SxCorpTeacher;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.service.SxCorpTeacherService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

/**
 * 校外导师控制器
 * @author lck
 */
@RestController
@RequestMapping("/corpteacher")
public class CorpTeacherController {

    @Autowired
    private SxCorpTeacherService sxCorpTeacherService;

    @GetMapping("/getAllStu")
    public ResponseVO getStudentsList() {
        return ControllerUtil.getDataResult(sxCorpTeacherService.getOwnedStudentsList(new SxCorpTeacher()));//模拟已登录的CorpTeacher
    }
    @GetMapping("/getStuIdentifyForm")
    public ResponseVO getStuIdentifyForm(){
        return ControllerUtil.getDataResult(sxCorpTeacherService.getIdentifyFormByStuId(new SxStudent()));
    }
    @GetMapping("/operateIdentifyForm")
    public ResponseVO operateIdentifyForm(String teacherOpinion, String teacherScore,String teacherGrade){//前端传入校外导师的意见，打分，评定等级
        return ControllerUtil.getDataResult(sxCorpTeacherService.operateIdentifyForm(new SxStudent(),teacherOpinion,teacherScore,teacherGrade));
    }
}
