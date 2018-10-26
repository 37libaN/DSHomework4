package defragmenter;
import java.util.*;
public class Defragment {
	private SortedLinkedList<SortedLinkedList<Fragment>> list;
	public Defragment(){
		list = new SortedLinkedList<SortedLinkedList<Fragment>>();
	}
	public void addFrag(int id, int froff, int length, boolean morefrag) {
		SortedLinkedList<Fragment> listFrag = new SortedLinkedList<Fragment>();
		Fragment toAdd = new Fragment(id, froff, length, morefrag);
		if(list.find(toAdd)){
			list.getFoundNode().getInfo();	
			listFrag.add(toAdd);
		}
		else{
			listFrag.add(toAdd);
			list.add(listFrag);
		}
	}
	public String toString() {
		String toString = "";
		list.reset();
		while(list.getNode()!=null){
			toString = toString + "Packet " + list.getNode().getInfo().getID() + ", " + list.getNode().getInfo().fragmentLength + " bytes";
			list.step();
		}
		return toString;
	}
	
	static void main(String[] args) {
		
	}
}
class Fragment implements Comparable{ //class to store info for each fragment
	private int packetID;
	private int fragmentOffset;
	private int fragmentLength;
	private boolean moreFragmentsBit;
	Fragment(int id, int froff, int length, boolean morefrag){
		packetID = id;
		fragmentOffset = froff;
		fragmentLength = length;
		moreFragmentsBit = morefrag;
	}
	public int getID(){
		return packetID;
	}
	public void toString(){
		System.out.println(packetID);
	}
	@Override
	public int compareTo(Object objCompare){
		if(fragmentOffset < ((Fragment)objCompare).fragmentOffset)
			return -1;
		else if(fragmentOffset == ((Fragment)objCompare).fragmentOffset)
			return 0;
		else 
			return 1;
	}
}