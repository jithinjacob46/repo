/**
 * 
 */
package com.practice.hackerrank.list;

/**
 * @author jacob
 *
 */
public class SinglyLinkedListNode {

	int data;
	SinglyLinkedListNode next;

	/**
	 * @param data
	 */
	public SinglyLinkedListNode(int data) {

		this.data = data;
	}

	/**
	 * @param head
	 * @param data
	 * @return
	 */
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

		if (head == null) {
			head = new SinglyLinkedListNode(data);
		} else {

			SinglyLinkedListNode node = head;
			while (node != null && node.next != null) {
				node = node.next;
			}
			node.next = new SinglyLinkedListNode(data);
		}
		return head;
	}

	/**
	 * @param llist
	 * @param data
	 * @return
	 */
	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {

		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		node.next = llist;
		return node;
	}

	/**
	 * @param head
	 * @param data
	 * @param position
	 * @return
	 */
	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

		if (head == null || position == 0) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(data);
			node.next = head;
			head = node;
		} else {

			SinglyLinkedListNode node = head;
			while (node != null && position != 1) {
				node = node.next;
				position--;
			}
			SinglyLinkedListNode newnode = new SinglyLinkedListNode(data);
			newnode.next = node.next;
			node.next = newnode;
		}
		return head;
	}

	/**
	 * @param head
	 * @param position
	 * @return
	 */
	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

		if (head != null) {
			if (position == 0) {
				head = head.next;
			}
			SinglyLinkedListNode node = head;
			while (node != null && node.next != null && position != 1) {
				node = node.next;
				position--;
			}
			if (node.next == null) {
				node.next = null;
			} else {
				node.next = node.next.next;
			}

		}
		return head;
	}

}
