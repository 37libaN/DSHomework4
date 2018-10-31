/**
	 * COSC 2100 - Project 7
	 * This program simulates the fragmentation of packets of information sent over the internet.
	 * @author [Vishnu Appalaraju, Nabil Hussaini]
	 * Instructor [Dr. Brylow] 
	 * TA-BOT:MAILTO [srivishnu.appalaraju@marquette.edu nabil.hussaini@marquette.edu] 
	 */

package defragmenter;

import java.util.*;

public class Defragment {
	private SortedLinkedList<SortedLinkedList<Fragment>> list; // linked list is
																// declared

	public Defragment() {
		list = new SortedLinkedList<SortedLinkedList<Fragment>>();
	}

	public boolean completePacket(SortedLinkedList<Fragment> packet) { // checks
																		// to
																		// see
																		// if
																		// packet
																		// is
																		// complete
		if (!packet.isEmpty()) {
			if (packet.getList().getInfo().getFragmentOffset() == 0) { // check
																		// if
																		// packet
																		// starts
																		// properly
				packet.reset();
				boolean checkContinue = true; // true if the packet does not
												// have any gaps
				boolean checkEnd = false; // true if the packet ends
				if (packet.getNode() != null && !(packet.getNode().getInfo().getMoreFragmentsBit()))
					checkEnd = true;
				packet.step();
				int totalBytes = 0;
				if (!checkEnd) {
					while (packet.getNode() != null) {
						Fragment pastNode = packet.getPrev().getInfo();
						totalBytes += pastNode.getFragmentLength();
						if (!(totalBytes == packet.getNode().getInfo().getFragmentOffset())) {
							checkContinue = false;
						}
						if (!(packet.getNode().getInfo().getMoreFragmentsBit())) {// end
																					// in
																					// packet
							checkEnd = true;
							packet.step();
							break;
						}
						packet.step();
					}
				}
				if (checkContinue) {
					if (checkEnd) {
						packet.getPrev().setLink(null);
						return true;
					}
				}
				/*
				 * if (checkEarlyEnd){ packet.getNode().setLink(null);
				 * 
				 * }
				 */
			}
		}
		return false;
	}

	public void addFrag(int id, int froff, int length, boolean morefrag) { // fragments
																			// are
																			// added
																			// to
																			// the
																			// list
		SortedLinkedList<Fragment> listFrag = new SortedLinkedList<Fragment>();
		Fragment toAdd = new Fragment(id, froff, length, morefrag);
		if (list.find(toAdd)) {
			listFrag = list.getFoundNode().getInfo();
			int nextOffset = 0; // keep track of next highest offset in case
								// they're out of order
			int nextBytes = 0;
			// int totalBytes = 0; //total bytes already in listFrag
			int toAddBytes = 0; // total bytes toAdd should have
			boolean gapToFill = false; // if overlap fills gap in packet
			listFrag.reset();
			// totalBytes += listFrag.getNode().getInfo().getFragmentLength();
			if (listFrag.getNode().getInfo().equals(toAdd))
				return;
			nextBytes = listFrag.getNode().getInfo().getFragmentLength();
			nextOffset = listFrag.getNode().getInfo().getFragmentOffset();
			listFrag.step();
			while (listFrag.getNode() != null) {
				// totalBytes +=
				// listFrag.getNode().getInfo().getFragmentLength();
				if (listFrag.getNode().getInfo().equals(toAdd))
					return;
				nextBytes = listFrag.getNode().getInfo().getFragmentLength();
				nextOffset = listFrag.getNode().getInfo().getFragmentOffset();
				if (listFrag.getPrev().getInfo().getFragmentOffset()
						+ listFrag.getPrev().getInfo().getFragmentLength() < nextOffset) {
					if (toAdd.getFragmentOffset() > listFrag.getPrev().getInfo().getFragmentOffset()
							+ listFrag.getPrev().getInfo().getFragmentLength()
							&& toAdd.getFragmentOffset() < nextOffset) {
						gapToFill = true;
						break;
					}
				}
				listFrag.step();
			}
			toAddBytes = toAdd.getFragmentOffset() + toAdd.getFragmentLength();
			if (gapToFill) {
				if (toAddBytes > (nextOffset + nextBytes)) {
					toAdd.setFragmentLength(toAddBytes - (nextOffset + nextBytes));
				}
			} else if (toAddBytes > (nextOffset + nextBytes)) {
				toAdd.setFragmentOffset(nextOffset + nextBytes);
				toAdd.setFragmentLength(toAddBytes - (nextOffset + nextBytes));
			} 
			listFrag.add(toAdd);
		} else {
			listFrag.add(toAdd);
			list.add(listFrag);
		}
	}

	public String toString() { // checks to see if packet is complete, gets
								// appropriate info, then outputs
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
			}
			thisList = null;
			bytes = 0;
			list.step();
		}
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

	public void setFragmentLength(int fragmentLength) {
		this.fragmentLength = fragmentLength;
	}

	public void setFragmentOffset(int fragmentOffset) {
		this.fragmentOffset = fragmentOffset;
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

	public boolean equals(Fragment fragCompare) {
		if (this.getFragmentOffset() == fragCompare.getFragmentOffset()
				&& this.getFragmentLength() == fragCompare.getFragmentLength())
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(Object objCompare) {
		if (this.getFragmentOffset() < ((Fragment) objCompare).getFragmentOffset())
			return -1;
		else if (this.getFragmentOffset() == ((Fragment) objCompare).getFragmentOffset())
			return 0;
		else
			return 1;
	}
}