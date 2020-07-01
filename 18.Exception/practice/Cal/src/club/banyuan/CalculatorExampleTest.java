package club.banyuan;// package club.banyuan;
//
// import static org.junit.Assert.*;
//
// import org.junit.Assert;
//
// import org.junit.Test;
//
// public class CalculatorExampleTest {
//
//   /**
//    * 测试正确的情况
//    */
//   @Test
//   public void computeAdditionTest1() {
//     try {
//       Assert.assertEquals("计算的结果错误", 9,
//           Calculator.compute(new String[]{"4", "+", "5"}));
//     } catch (Exception e) {
//       Assert.fail("不应该抛出异常");
//     }
//   }
//
//   /**
//    * 测试退出
//    */
//   @Test
//   public void computeQuitTest1() {
//     try {
//       Calculator.compute(new String[]{"quit"});
//       Assert.fail("退出时应该抛出异常");
//     } catch (QuitException e) {
//       // Do nothing in this case
//     } catch (Exception e) {
//       Assert.fail("退出时应该抛出 QuitException");
//     }
//   }
//
//
//   /**
//    * Test Single Illegal Arg
//    */
//   @Test
//   public void computeSingleIllegalArgTest() {
//     try {
//       Calculator.compute(new String[]{"foo"});
//       Assert.fail("String \"foo\" 应该抛出异常");
//     } catch (IllegalInputException e) {
//       Assert.assertEquals("IllegalInputException 被生成, 消息内容必须为Illegal Argument", "Illegal Argument",
//           e.getMessage());
//     } catch (Exception e) {
//       Assert.fail("String \"foo\" 应该生成 IllegalInputException");
//     }
//   }
//
//
//   @Test
//   public void parseAndComputeAddition() {
//     Assert.assertFalse(
//         Calculator.parseAndCompute("4 + 2"));
//     Assert.assertTrue(
//         Calculator.parseAndCompute("quit"));
//   }
//
// }
