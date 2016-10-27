import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
public class CollectionClass {

	public static void main(String[] args) {
		List<Integer> al=new ArrayList<Integer>();
		al.add(4);
		al.add(2);
		al.add(1);
		al.add(3);
		al.add(4);
		al.add(Integer.parseInt("7"));
		List<Object> t=new ArrayList<Object>();
		t.add("Str");
		t.add(al);
		List<Integer> ll=new LinkedList<Integer>();
		ll.add(4);
		ll.add(2);
		ll.add(1);
		ll.add(3);
		ll.add(4);
		Vector<Integer> v=new Vector<Integer>();
		v.add(4);
		v.add(2);
		v.add(1);
		v.add(3);
		v.add(4);
		Queue<Integer> q=new PriorityQueue<Integer>();
		q.add(4);
		q.add(2);
		q.add(1);
		q.add(3);
		q.add(4);
		Set<Integer> hs=new HashSet<Integer>();
		hs.add(4);
		hs.add(2);
		hs.add(1);
		hs.add(3);
		hs.add(4);
		Set<Integer> lhs=new LinkedHashSet<Integer>();
		lhs.add(4);
		lhs.add(2);
		lhs.add(1);
		lhs.add(3);
		lhs.add(4);
		Set<Integer> ts=new TreeSet<Integer>();
		ts.add(4);
		ts.add(2);
		ts.add(1);
		ts.add(3);
		ts.add(4);
		Map<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("D", 65);
		hm.put("B", 66);
		hm.put("C", 67);
		hm.put("A", 65);
		hm.put("D", 68);
		Map<String,Integer> lhm=new LinkedHashMap<String,Integer>();
		lhm.put("D", 65);
		lhm.put("B", 66);
		lhm.put("C", 67);
		lhm.put("A", 65);
		lhm.put("D", 68);
		Map<String,Integer> tm=new TreeMap<String,Integer>();
		tm.put("D", 65);
		tm.put("B", 66);
		tm.put("C", 67);
		tm.put("A", 65);
		tm.put("D", 68);
		Hashtable<String,Integer> ht=new Hashtable<String,Integer>();
		ht.put("D", 65);
		ht.put("B", 66);
		ht.put("C", 67);
		ht.put("A", 65);
		ht.put("D", 68);
		
		System.out.println("Array List");
		Iterator<Integer> itr=al.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Array list for each");
		for(Integer i:al)
			System.out.println(i);
		System.out.println("Linked List");
		itr=ll.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Vector");
		itr=v.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Hash Set");
		itr=hs.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Linked Hash Set");
		itr=lhs.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Tree Set");
		itr=ts.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Hash Map");
		Iterator<Entry<String, Integer>> itrmap=hm.entrySet().iterator();
		while(itrmap.hasNext())
			System.out.println(itrmap.next());
		System.out.println("Linked Hash Map");
		itrmap=lhm.entrySet().iterator();
		while(itrmap.hasNext())
			System.out.println(itrmap.next());
		System.out.println("Tree Map");
		itrmap=tm.entrySet().iterator();
		while(itrmap.hasNext())
			System.out.println(itrmap.next());
		System.out.println("Hash Table");
		itrmap=ht.entrySet().iterator();
		while(itrmap.hasNext())
			System.out.println(itrmap.next());
		System.out.println("Queue");
		System.out.println("Queue Head "+q.element());
		System.out.println("Queue Head "+q.peek());
		itr=q.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Queue remove "+q.poll());
		System.out.println("Queue remove "+q.remove());
		System.out.println("Queue after removing");
		itr=q.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Generic List");
		Iterator<Object> objitr=t.iterator();
		while(objitr.hasNext())
			System.out.println(objitr.next());	
	}
}
