
import java.util.ArrayList;


public class IDLList<E> {
	
	//private inner class
	private class Node<E>{
		private E data;
		private Node<E>prev;
		private Node<E> next;
		
		//Constructor
		public Node(E elem) {
			data= elem;
			prev= null;
			next= null;
			
		}
		//Constructor for Node
		public Node(E elem, Node<E>prev, Node<E>next) {
			data=elem;
			this.prev=prev;
			this.next=next;
		}
		}
	private Node<E>head;//head variable start of linked list
	private Node<E>tail;//tail variable end of linked list
	private int size;//number of nodes in the list
	private ArrayList<Node<E>>indices;//list of nodes in indices
	
	//empty double linked list
	//constructor to create an empty list
	
	public IDLList() {
		head=null;
		tail=null;
		size=0;
		indices= new ArrayList<Node<E>>();
	}
	//boolean for fast access
	//error on line 49
	public boolean add(int index, E elem) {
		//deterimene index
		if(index>=0 && index<= size) {
			//insert head
		}
			if(index ==0) {
				add(elem);
				
		}
			//insert at the tail
		else if(index==size){
			append(elem);
			
		}
		else {
		//get node at index
		Node<E> curr= indices.get(index);
		Node<E>node = new Node<E>(elem,curr.prev,curr);
		//updating the next node 
		node.prev.next=node;
		//updating prev of curr
		curr.prev= node;
		//add node at index
		indices.add(index, node);
		//updating node at index -1 and index +1
		indices.set(index-1,  node.prev);
		indices.set(index +1, curr);
		size++;
		
			
		}
			return true;
		
	}
	
	
	//invalid index
	//return false;
	
	//method that adds elem at the head boolean add
	public boolean add(E elem) {
		//create new node
		Node<E>node = new Node<E>(elem, null,head);
		//empty list to tail needed
		if(head==null) {
			tail=node;
		}
		else {
			//non empty list
			head.prev=node;
			indices.set(0, head);
		}
		//update head to node
		head=node;
		//insert node at first index in indices
		indices.add(0,node);
		size++;
		return true;
	}

	//boolean append method to add elem as new last element of the list
	public boolean append(E elem) {
		//create new node 
		Node<E>node=new Node<E>(elem, tail, null);
		//code needed to update next tail to node
		tail.next=node;
		indices.set(size-1, tail);
		tail=node;
		//code needed to add node as the last element of indices
		indices.add(node);
		size++;
		return true;
	}
	
	//E public method that returns the object at position index from the head
	
	public E get(int index) {
		//determine index
		if(index>=0 && index<size) {
			return indices.get(index).data;
		}
		else {
			throw new IndexOutOfBoundsException("List index out of bounds");
		}
	}
		//method needed that returns object at the head
		public E getHead() {
			if(size>0) {
				return head.data;
			}
			else {
				throw new IllegalStateException("List is empty");
			}
		}
			
			public E getLast() {
				if(size>0) {
					return tail.data;
				}
				else {
					throw new IllegalStateException("List is empty");
				}
			}
				
				//need method that returns list size
				public int size() {
					return size;
				}
			
				
		//need method that removes and returns the element at the head
			public E remove() {
				if(size>0) {
					E data= head.data; //this gets the data in headnode
					head=head.next;// set head node to next
					size --;
					//removing the node at index 0
					indices.remove(0);
					if(head != null) {
						head.prev = null;
						indices.set(0, head);
						return null;
					}
					else {
						tail=null;
						
					return data;
					}
					
					
				}
				System.out.println("The size is less than zero");
				return null;
		
				}
					
					//remove elements at the tail
					
				public E removeLast() {
					if(size >0 ) {
						E data= tail.data;
						tail=tail.prev;
						size--;
						indices.remove(size);
						if(tail !=null) {
							tail.next= null;
							indices.set(size-1, tail);
						}
						else {
							head=null;
						return data;
							
						}
					}
					System.out.println("the Size is less than zero");
					return null;
						
					}
				public E removeAt(int index) {
					//validate index
					if(index >= 0 && index<size) {
						//code needed for removing tail
						if(index ==size-1) {
							return removeLast();
						}
						else {
						//node at index
						Node<E> node= indices.get(index);
						//removes the node
						indices.remove(index);
						//update next node at index -1 to next node
						indices.get(index-1).next= node.next;
						//code needed to remove node from list
						node.next=null;
						node.prev=null;
						size--;
						return node.data;
						
						}
					}
					return null;
				}
				
		//Method that removes the first occurence of element
				public boolean remove(E elem) {
					//set curr to head
					Node<E> curr= head;
					//code needed to set curr_index to zero
					int curr_index =0; 
					
					while(curr !=null) {
						if(curr.data.equals(elem)) {
						curr= curr.next;
						curr_index++;
						}
					if(curr==null) 
						return false;
					}
					removeAt(curr_index);
					return true;
					}
					
				//method String to String needed to return string Representation
				public String toString() {
					String str= "";
					Node<E> curr= head;
					
					//Loop over the list
					while(curr!= null) {
						str += curr.data.toString();
						if(curr!=tail) {
							str+= "->";
						curr = curr.next;
						}
						return str;
					}
					return null;
				}
}

			
		
	
