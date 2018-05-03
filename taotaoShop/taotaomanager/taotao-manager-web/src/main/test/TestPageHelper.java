import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.dao.TbItemMapper;
import ssm.pojo.TbItem;
import ssm.pojo.TbItemExample;

import java.util.List;

/**
 * Created by HotSauce on 2018/4/10.
 */
public class TestPageHelper {
    @Test
    public void testPageHelper(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:mybatis-spring.xml");
        TbItemMapper bean = applicationContext.getBean(TbItemMapper.class);
        TbItemExample tbItemExample = new TbItemExample();
        PageHelper.startPage(1,10);
        List<TbItem> tbItems = bean.selectByExample(tbItemExample);
        for (TbItem tbItem:tbItems){
            System.out.println(tbItem.getTitle());
        }
        PageInfo pageInfo = new PageInfo(tbItems);
        long total = pageInfo.getTotal();
        System.out.print("共有商品:"+total);
    }

}
