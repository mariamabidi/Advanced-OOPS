
public class TestNonSet {
    public static void testItWithString(SortedStorageNonSet aSortedStorageNonSet)	{

        String toInsert[] = { "8", null, null, "1", "2", "2"};
        String toDelete[] = { "1", null, null, null, "1"};
        String toFind[]   = { "1", null, "1"};


        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + aSortedStorageNonSet.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + aSortedStorageNonSet.includesNull());
        System.out.println("- toString: "  + aSortedStorageNonSet.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + aSortedStorageNonSet.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorageNonSet.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorageNonSet.delete(toDelete[index]));
        }
    }
    public static void testItWithIntegers(SortedStorageNonSet aSortedStorageNonSet)	{

        Integer toInsert[] = {  Integer.valueOf(8), null,  Integer.valueOf(1),  Integer.valueOf(2)};
        Integer toDelete[] = {  Integer.valueOf(8), null,  Integer.valueOf(1) };
        Integer toFind[]   = {  Integer.valueOf(8), null,  Integer.valueOf(1),  Integer.valueOf(2)};


        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + aSortedStorageNonSet.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + aSortedStorageNonSet.includesNull());
        System.out.println("- toIntegers: "  + aSortedStorageNonSet.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + aSortedStorageNonSet.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorageNonSet.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorageNonSet.delete(toDelete[index]));
        }
    }
    public static void testItWithSortedStorageNonSet(SortedStorageNonSet aSortedStorageNonSet,  SortedStorageNonSet[] theSortedStorageNonSets)	{
        SortedStorageNonSet toInsert[] = {  theSortedStorageNonSets[0], theSortedStorageNonSets[1], null, theSortedStorageNonSets[1] };
        SortedStorageNonSet toDelete[] = {  theSortedStorageNonSets[0], theSortedStorageNonSets[1], null };
        SortedStorageNonSet toFind[]   = {  theSortedStorageNonSets[0], theSortedStorageNonSets[1], null, theSortedStorageNonSets[1] };

        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + aSortedStorageNonSet.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + aSortedStorageNonSet.includesNull());
        System.out.println("- toIntegers: "  + aSortedStorageNonSet.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + aSortedStorageNonSet.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorageNonSet.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorageNonSet.delete(toDelete[index]));
        }
    }
    public void test()	{
        SortedStorageNonSet aSortedStringStorage = new SortedStorageNonSet();
        testItWithString(aSortedStringStorage);

        SortedStorageNonSet aSortedIntegerStorage = new SortedStorageNonSet();
        testItWithIntegers(aSortedIntegerStorage);

        SortedStorageNonSet aSortedSortedStorageNonSetStorage = new SortedStorageNonSet();
        SortedStorageNonSet[] theSortedStorageNonSets = { aSortedStringStorage, aSortedIntegerStorage, aSortedSortedStorageNonSetStorage };
        testItWithSortedStorageNonSet(aSortedSortedStorageNonSetStorage, theSortedStorageNonSets);
    }
    public static void main(String args[] )	{
        new TestNonSet().test();
    }
}
