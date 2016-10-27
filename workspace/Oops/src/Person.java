public class Person
	{
		String name;
		public Person()
		{
			name="";
		}
		public Person(String name)
		{
			setName(name);
		}
		public String getname()
		{
			return this.name;
		}
		public void setName(String name)
		{
			this.name=name;
		}
		public boolean isOutstanding()
		{
			return false;
		}
		public void display() {
		}
		public void print() {
		}
	}