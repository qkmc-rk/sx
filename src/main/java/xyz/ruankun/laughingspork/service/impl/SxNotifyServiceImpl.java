package xyz.ruankun.laughingspork.service.impl;
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

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ruankun.laughingspork.entity.SxNotify;
import xyz.ruankun.laughingspork.repository.SxNotifyRepository;
import xyz.ruankun.laughingspork.service.SxNotifyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SxNotifyServiceImpl implements SxNotifyService {
    @Autowired
    SxNotifyRepository sxNotifyRepository;

    @Override
    public List<SxNotify> findByPageAndLimit(int page, int limit) {
        List<SxNotify> sxNotifies = sxNotifyRepository.findAll();
        int size = sxNotifies.size();
        int start = (page - 1 >=  0)?(page-1)*limit:0;
        List<SxNotify> sxNotifiesNew = new ArrayList<>();
        for(int i = start; i < size; i++){
            SxNotify sxNotify = sxNotifies.get(i);
            sxNotify.setTotal(size);
            sxNotifiesNew.add(sxNotify);
            if (i - start >= limit){
                break;
            }
        }
        return sxNotifiesNew;
    }
}
