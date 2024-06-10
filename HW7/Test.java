public class Test {
    public static void testItWithString(SortedStorage aSortedStorage)	{

        String toInsert[] = { "8", null, "1", "2"};
        String toDelete[] = { "1", null, "1"};
        String toFind[]   = { "1", null, "1"};


        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + aSortedStorage.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + aSortedStorage.includesNull());
        System.out.println("- toString: "  + aSortedStorage.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + aSortedStorage.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorage.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorage.delete(toDelete[index]));
        }
    }
    public static void testItWithIntegers(SortedStorage aSortedStorage)	{

        Integer toInsert[] = {  Integer.valueOf(8), null,  Integer.valueOf(1),  Integer.valueOf(2)};
        Integer toDelete[] = {  Integer.valueOf(8), null,  Integer.valueOf(1) };
        Integer toFind[]   = {  Integer.valueOf(8), null,  Integer.valueOf(1),  Integer.valueOf(2)};


        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + aSortedStorage.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + aSortedStorage.includesNull());
        System.out.println("- toIntegers: "  + aSortedStorage.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + aSortedStorage.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorage.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorage.delete(toDelete[index]));
        }
    }
    public static void testItWithSortedStorage(SortedStorage aSortedStorage,  SortedStorage[] theSortedStorages)	{
        SortedStorage toInsert[] = {  theSortedStorages[0], theSortedStorages[1], null, theSortedStorages[1] };
        SortedStorage toDelete[] = {  theSortedStorages[0], theSortedStorages[1], null };
        SortedStorage toFind[]   = {  theSortedStorages[0], theSortedStorages[1], null, theSortedStorages[1] };

        for (int index = 0; index < toInsert.length; index ++ )	{
            System.out.println("- add(" + toInsert[index] + "): "  + aSortedStorage.add(toInsert[index]));
        }

        System.out.println("- includesNull: "  + aSortedStorage.includesNull());
        System.out.println("- toIntegers: "  + aSortedStorage.toString());

        for (int index = 0; index < toFind.length; index ++ )	{
            System.out.println("- find(" + toFind[index] + "): "  + aSortedStorage.find(toFind[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorage.delete(toDelete[index]));
        }
        for (int index = 0; index < toDelete.length; index ++ )	{
            System.out.println("- delete(" + toDelete[index] + "): "  + aSortedStorage.delete(toDelete[index]));
        }
    }
    public static void testItWithMusic(SortedStorage music){
        /**
         * This method is used to test the sorted Music storage with the
         * sorted storage for MusicStorageOfPast class.
         *
         */
        MusicStorageOfPast Music1 = new MusicStorageOfPast(2021, "dhruv","Heyya",2.3f ,2);
        MusicStorageOfPast Music2 = new MusicStorageOfPast(2023, "mariam","minions",2.7f ,7);
        MusicStorageOfPast Music3 = new MusicStorageOfPast(2022, "sam","waterfall",2.8f ,1);
        MusicStorageOfPast toInsert[] = { Music1,Music2, null, Music3 };
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


    public static void testItWithAddress(SortedStorage address){
        /**
         * This method is used to test the sorted Address storage with the
         * sorted storage for OldFashionedEmailAddress class.
         *
         */
        OldFashionedEmailAddress Address1 = new OldFashionedEmailAddress(8,"M.G street", "Mumbai", "Maharashtra",4533);
        OldFashionedEmailAddress Address2 = new OldFashionedEmailAddress(8,"M.G street", "Mumbai", "Maharashtra",4535);
        OldFashionedEmailAddress Address3 = new OldFashionedEmailAddress(3,"M.G street", "Mumbai", "Maharashtra",5633);
        OldFashionedEmailAddress toInsert[] = { Address1, Address2, null, Address3 };
        OldFashionedEmailAddress toDelete[] = { Address3, null};
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

    public void test()	{

        SortedStorage aSortedStringStorage = new SortedStorage();
        testItWithString(aSortedStringStorage);

        SortedStorage aSortedIntegerStorage = new SortedStorage();
        testItWithIntegers(aSortedIntegerStorage);

        SortedStorage aSortedSortedStorageStorage = new SortedStorage();
        SortedStorage[] theSortedStorages = { aSortedStringStorage, aSortedIntegerStorage, aSortedSortedStorageStorage };
        testItWithSortedStorage(aSortedSortedStorageStorage, theSortedStorages);

//        new test added for Sorted music storage
        SortedStorage aSortedMusicStorage = new SortedStorage();
        testItWithMusic(aSortedMusicStorage);

//        new test added for Sorted Address storage
        SortedStorage aSortedAddressStorage = new SortedStorage();
        testItWithAddress(aSortedAddressStorage);
    }
    public static void main(String args[] )	{
        new Test().test();
    }
}
