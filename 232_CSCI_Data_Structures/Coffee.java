
public class Coffee implements Comparable
{
    private int price;
    private String color;
    private String company;
    
    Coffee(int price, String color, String company)
    {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }
    
    public int compareTo(Object song)
    {
        
        
        Song otherSong = (Song) song;
        System.out.println("compare to being called " + artist + " and " + otherSong.artist);
        if (artist.compareTo(otherSong.artist) < 0)
        {
            return -1;
        }
        else if (artist.compareTo(otherSong.artist) == 0)
        {
            if (title.compareTo(otherSong.title) < 0)
            {
                 return -1;
             }
             else if (title.compareTo(otherSong.title) == 0)
            {
                if (year < otherSong.year)
                {
                    return -1;
                }
                else if (year == otherSong.year)
               {
                   return 0;
               }
               else
               {
                   return 1;
               }
            } else
            {
                return 1;   
            }
            
        }
        else
        {
            return 1;
        }
    }
    
    public String toString()
    {
        return artist + " released " + title + " in " + year;
    }
        
        
   
}
