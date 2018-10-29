package defragmenter;

import java.util.*;

public class Defragment {
	private SortedLinkedList<SortedLinkedList<Fragment>> list;

	public Defragment() {
		list = new SortedLinkedList<SortedLinkedList<Fragment>>();
	}

	public boolean goodPacket(SortedLinkedList<Fragment> thisList) {
		return true;
	}

	public void addFrag(int id, int froff, int length, boolean morefrag) {
		System.out.println("nabil");
		SortedLinkedList<Fragment> listFrag = new SortedLinkedList<Fragment>();
		Fragment toAdd = new Fragment(id, froff, length, morefrag);
		if (list.find(toAdd)) {
			listFrag = list.getFoundNode().getInfo();
			listFrag.add(toAdd);
		} else { System.out.println("halal");
			listFrag.add(toAdd);
			list.add(listFrag);
		}
		System.out.println("lit");
	}

	public String toString() {
		String toString = "";
		SortedLinkedList<Fragment> thisList; // the packet that is being dealt
												// with
		int bytes = 0;
		list.reset();
		while (list.getNode() != null) {
			thisList = list.getNode().getInfo();
			thisList.reset();
			while (thisList.getNode() != null) {
				bytes += thisList.getNode().getInfo().getFragmentLength();
				thisList.step();
			}
			thisList.reset();
			toString = toString + "Packet " + thisList.getNode().getInfo().getID() + ", " + bytes + " bytes\n";
			thisList = null;
			bytes = 0;
			list.step();
		}
		/*
		System.out.println("hi2");
		System.out.println(toString);
		*/
		return toString;
	}
	
	public boolean completePacket(SortedLinkedList<Fragment> x) {
		return true;
	}
}

class Fragment implements Comparable { // class to store info for each fragment
	private int packetID;
	private int fragmentOffset;
	private int fragmentLength;
	private boolean moreFragmentsBit;

	Fragment(int id, int froff, int length, boolean morefrag) {
		packetID = id;
		fragmentOffset = froff;
		fragmentLength = length;
		moreFragmentsBit = morefrag;
	}

	public int getID() {
		return packetID;
	}

	public int getFragmentLength() {
		return fragmentLength;
	}

	@Override
	public int compareTo(Object objCompare) {
		if (fragmentOffset < ((Fragment) objCompare).fragmentOffset)
			return -1;
		else if (fragmentOffset == ((Fragment) objCompare).fragmentOffset)
			return 0;
		else
			return 1;
	}
}