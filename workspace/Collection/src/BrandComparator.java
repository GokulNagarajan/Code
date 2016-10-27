import java.util.Comparator;


public class BrandComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.brandName.compareToIgnoreCase(o2.brandName)<0)
			return -1;
		else if(o1.brandName.compareToIgnoreCase(o2.brandName)>0)
			return 1;
		else
		{
			if(o1.description.compareToIgnoreCase(o2.description)<0)
				return -1;
			else if(o1.description.compareToIgnoreCase(o2.description)>0)
				return 1;
		}
		return 0;
	}

}
