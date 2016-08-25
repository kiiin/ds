package com.kiin.ds;
import com.kiin.ds.exceptions.KiinLLException;
/**
 * 
 * @author kuttik
 * This is a sample linked list
 *
 */
public class KiinLinkedList {
	
	/***
	 * Unlike conventional linked list, the head is the first element in this case. Very much a bad design
	 */
	private   KiinLLItem head=null;   	
    /**
	 * @return the lenCount
	 */
	public int getLenCount() {
		return lenCount;
	}


	/**
	 * Increment the counter or length field
	 */
	public void incrementLenCount() {
		this.lenCount = this.lenCount+1;
	}
	
	
	/***
	 * Decrement the counter variable 
	 */
	public void decrementLenCount() {
		this.lenCount = this.lenCount+1;
	}

	/***
	 * The length variable of linked list
	 */
	private int lenCount = 0;
	public KiinLinkedList() {
		
		}


	public int addItem(Object inItem) 
	{
		KiinLLItem currentItem,tmpItem = null;
		int itemsAdded = 0;
					
							
				if (head == null )
					{
					head = new KiinLLItem(inItem);
					tmpItem = null;
					}
				else
					tmpItem = new KiinLLItem(inItem);
				
				currentItem = head;
				
				while (currentItem.getNextItem() != null)
				{
					currentItem = currentItem.getNextItem();
					
				}				
				currentItem.setNextItem(tmpItem);				
				lenCount=lenCount+1;
				itemsAdded=1;				
					
				
		return itemsAdded;
	}
	
	public String toString()
	{
		String strOut="";
		
		if (head != null) {
			KiinLLItem currentItem = head.getNextItem();
			strOut += "[" + head.getItemVal().toString() + "]";
			while (currentItem != null) {
				strOut += "[" + currentItem.getItemVal().toString() + "]";
				currentItem = currentItem.getNextItem();
			}
		}
		
		return strOut;
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		KiinLinkedList kiinLinkedList = new KiinLinkedList();
		KiinLLItem tmpItem = null;
		
		try {
			System.out.println("The count in the begenning "+kiinLinkedList.lenCount);
			kiinLinkedList.addItem("0 item");
			kiinLinkedList.addItem("1 item");
			kiinLinkedList.addItem("2 Item");
			kiinLinkedList.addItem("3 Item");
			kiinLinkedList.addItem("4 Item");
			kiinLinkedList.addItem("5 Item");			
			//kiinLinkedList.addItem("Kooi",3);
			
			//kiinLinkedList.removeItem(4);
			kiinLinkedList.addItem("Kooi",4);
			System.out.println("The count at the moment "+kiinLinkedList.lenCount);
			for (int i=0; i<=kiinLinkedList.lenCount ; i++)
			{
				if ( kiinLinkedList.getItem(i) != null )
					{
					tmpItem = kiinLinkedList.getItem(i);
					System.out.println("Iterating through list at "+i+" value is "+tmpItem.getItemVal());
					}
			}
			
			System.out.println(kiinLinkedList.toString());
			
		} catch (KiinLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	*/
	
	public int addItem(Object inItem,int inIndex)
	{		
		int itemsAdded = 0;
		KiinLLItem tmpItem, tmpItemAddFrom,tmpItemAddBackHook = null;
		KiinLLItem currentItem = head;
		
	      if (inItem != null)
			
			{
			tmpItemAddFrom = new KiinLLItem(inItem);
			tmpItem = new KiinLLItem(inItem);
			}
			
		else
			throw new KiinLLException();
		for (int i=0; i<inIndex ; i++)
		{
			if ( currentItem.getNextItem() != null )
				{
				
				tmpItemAddBackHook=currentItem.getNextItem();
				tmpItemAddFrom = currentItem;
				currentItem=currentItem.getNextItem();
				
				}
			
		}
		
		tmpItemAddFrom.setNextItem(tmpItem);
		tmpItem.setNextItem(tmpItemAddBackHook);
		
		itemsAdded = 1;
		lenCount=lenCount+1;
		return itemsAdded;
	}
	
	
	public int removeItem(int inIndex) 
	{
		int itemsRemoved = 0;
		
		KiinLLItem currentItem = head;
		KiinLLItem tmpItem,tmpItem1 = null;	
		
			
		for (int i=0; i<inIndex; i++)
		{
			if ( currentItem.getNextItem() != null )
				 currentItem = currentItem.getNextItem();
					
		}
		tmpItem1 = currentItem.getNextItem();
		tmpItem = tmpItem1.getNextItem();
		currentItem.setNextItem(tmpItem);
		itemsRemoved=1;
		lenCount=lenCount-1;
		
		
		return itemsRemoved;
	}
	
	public Object getItem(int inIndex) 
	{
	
		KiinLLItem currentItem = head;
		Object tmpItem = null;
	
		for (int i=0; i<inIndex; i++)
		{
			if ( currentItem.getNextItem() != null )
				 currentItem = currentItem.getNextItem();
					
		}
		tmpItem = currentItem.getItemVal();	
		
		
		return tmpItem;
	}
	
}

/***
 * 
 * @author kuttik
 * Internal class represents an item in the linked list
 */
class KiinLLItem 
{
	Object itemVal = null;	
	
	/**
	 * @return the itemVal
	 */
	public Object getItemVal() {
		return itemVal;
	}

	/**
	 * @param itemVal the itemVal to set
	 */
	public void setItemVal(Object itemVal) {
		this.itemVal = itemVal;
	}

	/**
	 * @return the nextItem
	 */
	public KiinLLItem getNextItem() {
		return nextItem;
	}

	/**
	 * @param nextItem the nextItem to set
	 */
	public void setNextItem(KiinLLItem nextItem) {
		this.nextItem = nextItem;
	}

	KiinLLItem nextItem = null;
	
	public KiinLLItem(Object itemVal, KiinLLItem nextItem) {
		
		this.itemVal = itemVal;
		this.nextItem = nextItem;
	}
	
	public KiinLLItem(Object itemVal ) {
		
		this.itemVal = itemVal;
		this.nextItem = null;
	}	
}