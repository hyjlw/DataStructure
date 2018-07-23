/**
 * 
 */
package com.wei.ds.ll;

/**
 * @author LL
 * 
 */
public class DualLinkList {
	private DualEntry first;
	private DualEntry last;

	public DualLinkList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public boolean insertAfter(int data, int key) {
		DualEntry newEntry = new DualEntry(data);
		DualEntry current = first;
		while (current.data != key) {
			current = current.next;
			if (current == null) {
				return false;
			}
		}
		if (current == last) {
			newEntry.next = null;
			last = newEntry;
		} else {
			newEntry.next = current.next;
			current.next.previous = newEntry;
		}
		newEntry.previous = current;
		current.next = newEntry;

		return true;
	}

	public int deleteKey(int key) {
		DualEntry current = first;

		while (current.data != key) {
			current = current.next;
			if (current == null) {
				throw new RuntimeException("Can't find key: " + key
						+ " in this list.");
			}
		}
		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}
		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current.data;
	}

	public void displayForward() {
		System.out.println("List(first-->last)");
		DualEntry current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}

	public void displayBackward() {
		System.out.println("List(last-->first)");
		DualEntry current = last;
		while (current != null) {
			current.display();
			current = current.previous;
		}
		System.out.println();
	}

	public void insertFirst(int data) {
		DualEntry newEntry = new DualEntry(data);

		if (isEmpty()) {
			last = newEntry;
		} else {
			first.previous = newEntry;
		}
		newEntry.next = first;
		first = newEntry;
	}

	public void insertLast(int data) {
		DualEntry newEntry = new DualEntry(data);

		if (isEmpty()) {
			first = newEntry;
		} else {
			newEntry.previous = last;
		}
		last.next = newEntry;
		last = newEntry;
	}

	public int deleteFirst() {
		DualEntry entry = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return entry.data;
	}

	public int deleteLast() {
		DualEntry entry = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return entry.data;
	}
}
