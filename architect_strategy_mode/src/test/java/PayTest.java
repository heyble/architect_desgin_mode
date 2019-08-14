import com.demo.Order;
import com.demo.PayState;
import com.demo.payment.AliPay;
import com.demo.payment.OrderService;
import com.demo.payment.PayType;

public class PayTest {
    public static void main(String[] args) {
        Order order = new Order(20190814001001L, 520D);
        PayState result = OrderService.pay(order, PayType.WECHATPAY);
        System.out.println(result);

    }
}
