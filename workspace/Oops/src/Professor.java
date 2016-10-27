
public class Professor extends Person
	{
		int booksPublished;
		public Professor()
		{
			super();
			booksPublished=0;
		}
		public Professor(String name,int booksPublished)
		{
			super(name);
			this.booksPublished=booksPublished;
		}
		public void print()
		{
			System.out.println("Professor Name \t\tBooksPublished");
			System.out.println(name+"\t\t\t"+booksPublished);
		}
		public boolean isOutstanding()
		{
			if(booksPublished>4)
				return true;
			return false;
		}
	}