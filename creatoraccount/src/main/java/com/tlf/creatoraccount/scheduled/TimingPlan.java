/*

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component                //实例化
@Configurable             //注入bean
@EnableScheduling
public class TimingPlan {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleMapper roleMapper;

    @Scheduled(fixedRate  = 1000*60*60*4)
    public void doTimingPlan() {
        roleMapper.updateRole("cdb7251d-960e-4068-9449-7be2a51c4bad");
        logger.info("SUCCESS");
    }
}
*/
