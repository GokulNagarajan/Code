import java.util.Comparator;


public class PriceComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		if(o1.price<o2.price)
			return -1;
		else if(o1.price>o2.price)
			return 1;
		else
		{
			if(o1.productId.compareToIgnoreCase(o2.productId)<0)
				return -1;
			else if(o1.productId.compareToIgnoreCase(o2.productId)>0)
				return 1;
		}
		return 0;
	}

}
