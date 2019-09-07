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

}
