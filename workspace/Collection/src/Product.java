
public class Product implements Comparable<Product>{
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	public String productId,brandName,description;
	public double price;
	public Product()
	{
		productId="";
		brandName="";
		description="";
		price=0;
	}
	public String getProductId()
	{
		return this.productId;
	}
	public String getBrandName()
	{
		return this.brandName;
	}
	public String getDescription()
	{
		return this.description;
	}
	public double getPrice()
	{
		return this.price;
	}
	@Override
	public int compareTo(Product o) {
		if(productId.compareToIgnoreCase(o.productId)<0)
			return -1;
		else if(productId.compareToIgnoreCase(o.productId)>0)
			return 1;
		else
		{
			if(brandName.compareToIgnoreCase(o.brandName)<0)
				return -1;
			else if(brandName.compareToIgnoreCase(o.brandName)>0)
				return 1;	
		}
		return 0;
	}
}
