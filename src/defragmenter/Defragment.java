package defragmenter;

public class Defragment {

class Fragment{
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
}
	public Defragment(){
		
	}
	public void addFrag(int id, int froff, int length, boolean morefrag) {
		
	}
	public String toString() {
		
	}
	
	static void main(String[] args) {
		
	}
}
