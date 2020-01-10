package xyz.ruankun.laughingspork.repository;
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

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ruankun.laughingspork.entity.SxNotify;

import java.util.Date;
import java.util.List;

public interface SxNotifyRepository extends JpaRepository<SxNotify, Integer> {

    /**
     * 按照时间查找
     * @param start
     * @param end
     * @return
     */
    List<SxNotify> findAllByGmtCreateBetween(Date start, Date end);
}
