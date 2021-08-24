import com.xingxin.service.FactoryApplication;
import com.xingxin.service.PaymentService;
import com.xingxin.service.factory.PaymentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxh
 * @date 2021/8/24
 */
@SpringBootTest(classes = FactoryApplication.class)
@RunWith(SpringRunner.class)
public class PayTest {

    @Test
    public void payTest() {
        PaymentService paymentService = PaymentFactory.getPaymentService("ALI_PAY");
        paymentService.pay();
        PaymentService paymentService1 = PaymentFactory.getPaymentService("WECHAT_PAY");
        paymentService1.pay();
    }
}
