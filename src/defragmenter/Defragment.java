/**
	 * COSC 2100 - Project 7
	 * 
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */
package defragmenter;

import java.util.*;

public class Defragment {
	private SortedLinkedList<SortedLinkedList<Fragment>> list;

	public Defragment() {
		list = new SortedLinkedList<SortedLinkedList<Fragment>>();
	}

	public boolean completePacket(SortedLinkedList<Fragment> packet) {
		System.out.println("Complete");
		if (!packet.isEmpty()) {
			System.out.println("here");
			if (packet.getList().getInfo().getFragmentOffset() == 0) { // check
																		// if
																		// packet
																		// starts
																		// properly
				System.out.println("here2");
				packet.reset();
				boolean checkContinue = true; // true if the packet does not
												// have any gaps
				packet.step();
				while (packet.getNode() != null) {
					Fragment pastNode = packet.getPrev().getInfo();
					if (!(pastNode.getFragmentLength() == packet.getNode().getInfo().getFragmentOffset())) {
						checkContinue = false;
						
					}
				}
				if (checkContinue) {
					System.out.println("here3");
					if (!(packet.getPrev().getInfo().getMoreFragmentsBit()))
						return true;
				}
			}
		}
		return false;
	}

	public void addFrag(int id, int froff, int length, boolean morefrag) {
		System.out.println("nabil");
		SortedLinkedList<Fragment> listFrag = new SortedLinkedList<Fragment>();
		Fragment toAdd = new Fragment(id, froff, length, morefrag);
		if (list.find(toAdd)) {
			// System.out.println("haram");

			listFrag = list.getFoundNode().getInfo();
			listFrag.add(toAdd);
		} else {
			// System.out.println("halal");
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
			if (completePacket(thisList)) {
				thisList.reset();
				while (thisList.getNode() != null) {
					bytes += thisList.getNode().getInfo().getFragmentLength();
					thisList.step();
				}
				thisList.reset();
				toString = toString + "Packet " + thisList.getNode().getInfo().getID() + ", " + bytes + " bytes\n";
				thisList = null;
				bytes = 0;
			}
			list.step();
		}
		/*
		 * System.out.println("hi2"); System.out.println(toString);
		 */
		return toString;
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

	public boolean getMoreFragmentsBit() {
		return moreFragmentsBit;
	}

	public int getFragmentOffset() {
		return fragmentOffset;
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