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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ruankun.laughingspork.service.SxNotifyService;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.vo.ResponseVO;

@RestController
@RequestMapping("/notify")
@CrossOrigin
public class NotifyController {

    @Autowired
    SxNotifyService sxNotifyService;

    @GetMapping("")
    public ResponseVO getNotify(@RequestParam(required = false) Integer page
            ,@RequestParam(required = false) Integer limit){
        if (null == page || null == limit){
            return ControllerUtil.getDataResult(sxNotifyService.findByPageAndLimit(1,1000));
        }else{
            return ControllerUtil.getDataResult(sxNotifyService.findByPageAndLimit(page, limit));
        }
    }
}
