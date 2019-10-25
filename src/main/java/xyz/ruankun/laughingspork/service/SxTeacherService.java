package xyz.ruankun.laughingspork.service;

import xyz.ruankun.laughingspork.entity.SxIdentifyForm;
import xyz.ruankun.laughingspork.entity.SxStudent;
import xyz.ruankun.laughingspork.entity.SxTeacher;

public interface SxTeacherService {
    SxTeacher getByTeacherNo(String teacherNo);
    SxIdentifyForm fillIndentifyAdvice(SxStudent sxStudent, String CTOpnion, String CTScore);

}
