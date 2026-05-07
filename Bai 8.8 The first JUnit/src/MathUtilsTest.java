public class MathUtilsTest {
    // Giả lập annotation để biên dịch không lỗi
    public @interface Test {}
    public @interface BeforeAll {}
    public @interface AfterAll {}

    @BeforeAll
    public static void setup() {
        System.out.println("=== Bat dau chay MathUtilsTest ===");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("=== Ket thuc ===");
    }

    public static void main(String[] args) {
        setup();
        try {
            // Test Max
            assert MathUtils.max(10, 5) == 10;
            assert MathUtils.max(5, 5) == 5;
            assert MathUtils.max(5, 10) == 10;
            assert MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE) == Integer.MAX_VALUE;
            
            // Test Divide
            assert MathUtils.divide(10, 2) == 5;
            boolean caught = false;
            try { MathUtils.divide(10, 0); } catch (IllegalArgumentException e) { caught = true; }
            assert caught;
            
            System.out.println("Tat ca cac test case da vuot qua.");
        } catch (AssertionError e) {
            System.err.println("Test that bai!");
        }
        tearDown();
    }
}