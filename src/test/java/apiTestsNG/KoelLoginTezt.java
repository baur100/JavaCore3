package apiTestsNG;

import helpers.Tokenz;
import org.testng.annotations.Test;

public class KoelLoginTezt {
    @Test
    public void testTokenCreation() {
        String token = Tokenz.get("koeluser03@testpro.io", "te$t$tudent");
        System.out.println(token);
    }
}
