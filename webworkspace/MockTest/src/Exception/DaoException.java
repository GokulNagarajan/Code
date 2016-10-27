package Exception;

public class DaoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DaoException(String e) {
		System.out.println(e.toString());
	}

}
