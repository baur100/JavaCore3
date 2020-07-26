package apiPetStore;

import helpersO.Token;
import org.testng.annotations.Test;

public class KoelLoginTest {
    @Test
    public void testTokenCreation(){
        String token = Token.get("testpro.user03@testpro.io","te$t$tudent");
        System.out.println(token);
    }
}
