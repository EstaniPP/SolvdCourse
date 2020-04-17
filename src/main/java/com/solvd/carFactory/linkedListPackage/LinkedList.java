package com.solvd.carFactory.linkedListPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList {

	private final static Logger LOGGER = LogManager.getLogger(LinkedList.class);
	
	private Node first;
	private Node last;
	private Integer size;
	
	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public void add(Integer index, Object elem) {
		if(index > size) {
			LOGGER.error(new IndexOutOfBoundsException());
		} else if(size == 0) {
			Node elemNode = new Node(null,null,elem);
			first = elemNode;
			last = elemNode;
		} else if(index == 0) {
			Node elemNode = new Node(null,first,elem);
			first.setPrevious(elemNode);
			first = elemNode;
		} else if(index == size) {
			Node elemNode = new Node(last,null,elem);
			last.setNext(elemNode);
			last = elemNode;
		} else {
			Node it = first;
			for(int i=0; i < index; i++) {
				it = it.getNext();
			}
			Node elemNode = new Node(it.getPrevious(),it,elem);
			it.getPrevious().setNext(elemNode);
			it.setPrevious(elemNode);
		}
		size++;
	}
	
	public void add(Object elem) {
		if(size == 0) {
			Node elemNode = new Node(null,null,elem);
			first = elemNode;
			last = elemNode;
		} else {
			Node elemNode = new Node(last,null,elem);
			last.setNext(elemNode);
			last = elemNode;
		}
		size++;
	}
	
	public Object get(Integer index) {
		if(index > size) {
			LOGGER.error(new IndexOutOfBoundsException());
		} 
		Node it = first;
		for(int i = 0; i < index; i++) {
			it = it.getNext();
		}
		return it.getElem();
	}
	
	public Integer getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		Node it = first;
		for(int i = 0; i < size; i++) {
			str.append("[" + it.getElem().toString() + "]");
			it = it.getNext();
		}
		return str.toString();
	}
	
	public String toStringReverse() {
		StringBuilder str = new StringBuilder();
		Node it = last;
		for(int i = 0; i < size; i++) {
			str.append("[" + it.getElem().toString() + "]");
			it = it.getPrevious();
		}
		return str.toString();
	}
	
	public void removeAt(Integer index) {
		if(index > size) {
			LOGGER.error(new IndexOutOfBoundsException());
		}else if(index == 0) {
			first = first.getNext();
			size--;	
		} else if(index == size) {
			last = last.getPrevious();
			size--;	
		} else {
			Node it = first;
			for(int i=0; i < index; i++) {
				it = it.getNext();
			}
			it.getPrevious().setNext(it.getNext());
			it.getNext().setPrevious(it.getPrevious());
			size--;	
		}
	}
	
	public void removeObj(Object obj) {
		if(first.getElem().equals(obj)) {
			first = first.getNext();
			size--;	
		} else if(last.getElem().equals(obj)) {
			last = last.getPrevious();
			size--;	
		} else {
			Node it = first;
			for(int i=0; i < size; i++) {
				if(it.getElem().equals(obj)) {
					break;
				}
				it = it.getNext();
			}
			it.getPrevious().setNext(it.getNext());
			it.getNext().setPrevious(it.getPrevious());
			size--;	
		}
	}
	
	private class Node{
		private Node previous;
		private Node next;
		private Object elem;
		
		public Node(Node prev, Node next, Object elem) {
			this.previous = prev;
			this.next = next;
			this.elem = elem;
		}
		
		public Object getElem() {
			return elem;
		}
		
		public Node getNext() {
			return next;
		}
		
		public Node getPrevious() {
			return previous;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
	}
}
