import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Movie {

	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","Welcome123");  
			System.out.println("Connecting the database");
			Statement stmt=con.createStatement();
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nSelecting Cast of the film \"Alien\"\n");
			String sql="select actor.name from actor "+
			"inner join casting on casting.actorid = actor.id "+
			"inner join movie on casting.movieid = movie.id "+
			"where movie.title like 'Alien'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nSelecting List of the films Julie Roberts Acted\n");
			sql="select movie.title from movie "+
			"inner join casting on movie.id = casting.movieid "+
			"inner join actor on casting.actorid=actor.id "+
			"where actor.name like 'Julia Roberts'";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nSelecting List of the films Julie Roberts Acted but not in Star Role\n");
			sql="select title from movie "+
			"inner join casting on movie.id = casting.movieid "+
			"inner join actor on casting.actorid=actor.id "+
			"where actor.name like 'Julia Roberts' and casting.ord>2";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nSelecting List of the Actors worked with Angelina Jolie\n");
			sql="select actor.name from actor "+
			"inner join casting on casting.actorid=actor.id "+
			"where actor.name not like 'Angelina jolie' "+
			"inner join actor a on casting.actorid=a.id "+
			"where a.name like 'Angelina Jolie')";
			sql="select name from actor "+
			"inner join casting on casting.actorid=actor.id "+
			"where name not like 'Angelina jolie' and "+
			"casting.movieid in (select cs.movieid from casting cs "
			+"inner join actor a on cs.actorid=a.id "+
			"where a.name like 'Angelina Jolie')";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("\nClosing the database");
			con.close();  
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
}
