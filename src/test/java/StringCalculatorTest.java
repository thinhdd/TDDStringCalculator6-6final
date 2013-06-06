import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: RuaTre_IT
 * Date: 6/6/13
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculatorTest {
    @Test
    public void testEmpty()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add(""),0);
    }
    @Test
    public void testOneNumber()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1"),1);
    }
    @Test
    public void testOneDeli()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1,2"),3);
    }
    @Test
    public void testTwoDeli()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1,2\n3"),6);
    }
    @Test
    public void testTwoErrorDeli()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1,\n2"),-1);
    }

    @Test
    public void testSpecOneDeli()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("//;\n1;2;3"), 6);
    }
    @Rule
    public ExpectedException ex= ExpectedException.none();
    @Test
    public void testNeganumber()
    {
        StringCalculator sc = new StringCalculator();
        ex.expectMessage("-1 -2 ");
        Assert.assertEquals(sc.add("-1,-2"),-1);

    }
    @Test
    public void testBigNumber()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1000,3"), 3);
    }
    @Test
    public void testOneStringDeli()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("//[***]\n1***2"), 3);
    }
    @Test
    public void testTwoStringDeli()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("//[***][,,]\n1***2,,3"), 6);
    }

}
//class Check{
//    public static void main(String[] args) {
//        String list ="";
//        String s= "//[***][,,]\n1***2,,4";
//        String arc = s.substring(s.indexOf("\n"),s.length()) ;
//        String listDe = s.substring(3,s.indexOf("\n")-1);
//        String curs[] = listDe.split(Pattern.quote("]["));
//        for(String i : curs)
//            list = list+Pattern.quote(i+"+");
//        list ="["+list+"]";
//        String cur[] = arc.split(list);
//        for(String j : cur)
//            System.out.println(j);
//    }
//}
