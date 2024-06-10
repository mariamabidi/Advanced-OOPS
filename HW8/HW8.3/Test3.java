import java.util.Comparator;

public class Test3 {
    MyList<String> aList = new MyList<String>();
    public void init()	{
        String[] theWords = { "a", "c", "b" };
        String[] gotTheWords;
        for ( int index = 0; index < theWords.length; index ++ )
            aList.add(theWords[index]);
    }
    public void testNatural()	{
        System.out.println("natural before sort - aList: " + aList );
        MyCollections.sort(aList);
        System.out.println("natural after  sort - aList: " + aList );
    }
    public void testReverse()	{
        System.out.println("reverse aList: " + aList );
        Comparator myComparator = new MyComparator();
        MyCollections.sort(aList, myComparator);
        System.out.println("reverse aList: " + aList );
    }
    public static void main(String args[]) {
        Test3 natural = new Test3();
        natural.init();
        natural.testNatural();
        Test3 reverse = new Test3();
        reverse.init();
        reverse.testReverse();
    }

}