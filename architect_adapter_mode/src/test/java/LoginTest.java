import com.architect.passport.LoginForThridService;
import com.architect.passport.LoginService;
import org.junit.Test;


public class LoginTest {

    @Test
    public void loginTest(){
        LoginService loginService = new LoginService();
        loginService.login(123L, "123");
    }

    @Test
    public void thridLoginTest(){
        LoginForThridService thridService = new LoginForThridService();
        String s = thridService.loginForQQ(234L);
    }
}
