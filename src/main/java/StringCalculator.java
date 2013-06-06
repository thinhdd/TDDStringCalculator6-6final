import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: RuaTre_IT
 * Date: 6/6/13
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public int add(String s) {
        if(s.isEmpty())
            return 0;
        if(s.contains("//") && s.contains("\n"))
        {
            if(s.indexOf("\n")-s.indexOf("//")>3)
            {

                String listDe = s.substring(3,s.indexOf("\n")-1);
                String curDe[] = listDe.split(Pattern.quote("]["));
                String list = "";
                String curs[] = listDe.split(Pattern.quote("]["));
                for(String i : curs)
                    list = list+Pattern.quote(i+"+");
                list ="["+list+"]";
                String arc = s.substring(s.indexOf("\n")+1,s.length());
                String cur[] = arc.split(list);
                return Sum(cur);
            }
            else
            {
                String arc = s.substring(4,s.length());
                String cur[] = arc.split(String.valueOf(s.charAt(2)));
                return Sum(cur);
            }
        }
        if(s.contains(",\n") || s.contains("\n,"))
            return -1;
        if(s.contains(",") && s.contains("\n"))
        {
            String cur[] = s.split("[,\n]");
            return Sum(cur);
        }
        if(s.contains(","))
        {
            String cur[] = s.split(",");
            return Sum(cur);
        }
        return Integer.parseInt(s);  //To change body of created methods use File | Settings | File Templates.
    }

    private int Sum(String[] cur) {
        int sum=0;
        String list="";
        for(int i=0; i<cur.length; i++)
        {
            if(!cur[i].isEmpty())
            {
                if(Integer.parseInt(cur[i])>0)
                {
                    if(Integer.parseInt(cur[i])<1000)
                    {
                        sum=sum+Integer.parseInt(cur[i]);
                    }
                }
                else
                    list=list+cur[i]+" ";
            }
        }
        if(list.length()>0)
            throw new IllegalArgumentException(list);
        return sum;  //To change body of created methods use File | Settings | File Templates.
    }
}
