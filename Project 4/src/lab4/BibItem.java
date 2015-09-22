package lab4;
import java.util.Scanner;
public class BibItem
{
	
	public String toString()
	{
		return authors + title + journal + year + volume;

	}

  private String authors;
  private String title;
  private String journal;
  private int year;
  private int volume;

  public BibItem(String givenAuthors,
      String givenTitle,
      String givenJournal,
      int givenYear,
      int givenVolume)
  { 
    authors = givenAuthors;
    title = givenTitle;
    journal = givenJournal;
    year = givenYear;
    volume = givenVolume;
  }
  
}