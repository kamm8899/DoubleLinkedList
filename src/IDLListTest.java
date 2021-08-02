
public class IDLListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDLList<Integer>list=new IDLList<Integer>();
		
		list.add(0,5);
		list.add(0,10);
		list.add(1,20);
		list.add(1,25);
		list.add(2,30);
		System.out.println("Size:" + list.size());
		System.out.print(list);
		
		System.out.println("Get element at index 3:" +list.get(3));
		System.out.println("Get head:" + list.getHead());
		System.out.println("Get tail: " + list.getLast());
		
		
		//Test case for remove At
		System.out.println("Remove index 3: " + list.removeAt(3));
		System.out.println("Size: " + list.size());
		System.out.println(list);
		
		//Remove specific node number 30
		System.out.println("Remove 30: "+ list.remove(30));
		System.out.println("Size: "+ list.size());
		System.out.println(list);
		
		
		System.out.println("Remove " + list.remove());
		System.out.println("Size: " + list.size());
		System.out.println(list);
		
		//test case for removeLast
		System.out.println("Remove Last " + list.removeLast());
		System.out.println("Size: " + list.size());
		System.out.println(list);
		
		

	}

}
