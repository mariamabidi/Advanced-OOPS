
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

        //        new test added for Sorted music storage
        SortedStorageNonSet aSortedMusicStorage = new SortedStorageNonSet();
        testItWithMusicNonSet(aSortedMusicStorage);

//        new test added for Sorted Address storage
        SortedStorageNonSet aSortedAddressStorage = new SortedStorageNonSet();
        testItWithAddressNonSet(aSortedAddressStorage);
    }

    private void testItWithAddressNonSet(SortedStorageNonSet address) {
        /**
         * This method is used to test the sorted Address storage with the
         * sorted storage for OldFashionedEmailAddress class.
         *
         */
        OldFashionedEmailAddress Address1 = new OldFashionedEmailAddress(8,"M.G street", "Mumbai", "Maharashtra",4533);
        OldFashionedEmailAddress Address2 = new OldFashionedEmailAddress(8,"M.G street", "Mumbai", "Maharashtra",4535);
        OldFashionedEmailAddress Address3 = new OldFashionedEmailAddress(3,"M.G street", "Mumbai", "Maharashtra",5633);
        OldFashionedEmailAddress toInsert[] = { Address1, Address1, Address2, null, Address3 };
        OldFashionedEmailAddress toDelete[] = { Address1, Address1, Address3, null, Address1};
        OldFashionedEmailAddress toFind[]   = { Address1, Address3, null};

        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + address.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + address.includesNull());
        System.out.println("- toAddress: "  + address.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + address.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + address.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + address.delete(toDelete[index]));
        }
    }


    private void testItWithMusicNonSet(SortedStorageNonSet music) {
        /**
         * This method is used to test the sorted Music storage with the
         * sorted storage for MusicStorageOfPast class.
         *
         */
        MusicStorageOfPast Music1 = new MusicStorageOfPast(2021, "dhruv","Heyya",2.3f ,2);
        MusicStorageOfPast Music2 = new MusicStorageOfPast(2023, "mariam","minions",2.7f ,7);
        MusicStorageOfPast Music3 = new MusicStorageOfPast(2022, "sam","waterfall",2.8f ,1);
        MusicStorageOfPast toInsert[] = { Music1,Music2,null, null, Music3 };
        MusicStorageOfPast toDelete[] = { Music2, null};
        MusicStorageOfPast toFind[]   = { Music1, Music2, null};
        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + music.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + music.includesNull());
        System.out.println("- toMusic: "  + music.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + music.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + music.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + music.delete(toDelete[index]));
        }
    }

    public static void main(String args[] )	{
        new TestNonSet().test();
    }
}


