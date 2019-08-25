import com.architect.old.impl.LoginService;
import com.architect.upgrade.impl.LoginForThridService;

public class LoginForThridTest {
    public static void main(String[] args) {
        LoginForThridService thridService = new LoginForThridService(new LoginService());
        thridService.loginForWeChat(345L);
    }
}
