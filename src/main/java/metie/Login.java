package metie;

public class Login {
	private int id ;
	private String login ;
	private String password ;
	// constructors 
	
	public  Login()
	{
		super();
	}
	
	public Login(int id , String login , String password)
	{
		this.id = id ;
		this.login = login ;
		this.password = password ;
	}
	
	// getters and setters 
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id= id ;
	}
	
	public String getLogin()
	{
		return this.login;
	}
	
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	
	public void setPassword(String  password)
	{
		this.password=password;
	}
	
	
}
