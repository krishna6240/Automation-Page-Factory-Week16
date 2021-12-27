package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "Valid Credentials")
    public static Object[][] objectTestData() {
        return new Object[][]{
                {"krishna", "Patel", "abc12456", "123 Abc Street", "London", "Florida","12345", "01234567890","MY ACCOUNT", "krishna Patel"},
        };
    }

    @DataProvider(name = "Invalid Credentials")
    public static Object[][] objectTestData2() {
        return new Object[][]{
                {"$%1234", "DD12**", "abc$%12456", "123 Abc Str%%t", "Lo$%^on", "Florida","123ssa45", "0123abcd67890","There are 6 errors"},
        };
    }

    @DataProvider(name = "Deletion Test")
    public static Object[][] objectTestData3() {
        return new Object[][]{
                {"Women", "Summer Dresses","Your shopping cart is empty."},
        };
    }


}
