public class MusicStorageOfPast implements Comparable<MusicStorageOfPast>{
    /**
     * It is a class to store MusicStorage elements like year, artist, title,
     * length and tracks in various formats. This class implements Comparable
     * interface to compare the values and store them in a sorted manner and
     * so that it can perform add, remove and other functionality.
     */
    int year;
    String artist;
    String title;
    float length;
    int tracks;

    MusicStorageOfPast(Integer year, String artist, String title, float length, Integer tracks){
        /**
         * This is a constructor for the class MusicStorageOfPast.
         */
        this.year = year;
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.tracks = tracks;
    }
//        to String method for the same.
    public String toString(){return "[" +this.year + " | "+ this.artist + " | " +this.title + " | "+ this.length+" | "+this.tracks+ "]";}

    @Override
    public int compareTo(MusicStorageOfPast m) {
        /**
         * This is an override of the abstract class from comaparable
         * which needs to be overridden for the class MusicStorageOfPast.
         * We compare the various values entered in the storage to sort and
         * store them.
         */
        if(this.year == m.year){
            if(this.artist.compareTo(m.artist)==0){
                if(this.title.compareTo(m.title)==0){
                    if(this.length== m.length) {
                        if (this.tracks == m.tracks) {
                            return 0;
                        } else if (this.tracks > m.tracks) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                    else if(this.length>m.length){
                        return 1;
                        }
                    else{
                        return -1;
                    }
                }
                else if(this.title.compareTo(m.title)>0){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else if (this.artist.compareTo(m.artist) > 0) {
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(this.year>m.year){
            return 1;
        }
        else{
            return -1;
        }
    }
}