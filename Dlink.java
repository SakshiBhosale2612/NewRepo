import java.util.*;

public class Dlink {
	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	Node head;

	public static Dlink CreateDLL(Dlink list, int data) {
		Node currnode;
		Node newnode = new Node(data);
		if (list.head == null) {
			list.head = newnode;
		} else {
			currnode = list.head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			currnode.next = newnode;
			newnode.prev = currnode;
		}

		return list;
	}

	public static Dlink display(Dlink list) {
		Node currnode;
		currnode = list.head;
		if (list.head == null) {
			System.out.println("List is Empty!!!");
		} else {
			System.out.println();
			System.out.print("DLL : ");
			while (currnode != null) {

				System.out.print(currnode.data + " ");
				currnode = currnode.next;
			}
		}
		System.out.println("\n");
		return list;
	}

// insert at End
	public static Dlink insertAtEnd(int data, Dlink list) {
		Node currnode;
		Node newnode = new Node(data);
		if (list.head == null) {
			System.out.println("DLL was empty so, this is 1st node");
			list.head = newnode;
		} else {
			currnode = list.head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			currnode.next = newnode;
			newnode.prev = currnode;
		}
		return list;
	}

// insert at START
	public static Dlink insertatstart(int data, Dlink list) {

		Node currnode;
		Node newnode = new Node(data);
		newnode.next = null;
		if (list.head == null) {
			System.out.println("DLL was empty so, this is 1st node");
			list.head = newnode;
		} else {
			currnode = list.head;
			currnode.prev = newnode;
			newnode.next = currnode;
			list.head = newnode;

		}
		return list;
	}
	// insert by position

	public static Dlink insertAtPPosition(int key, int data, Dlink list) {
		Node currnode;
		Node newnode = new Node(data);
		if (list.head == null) {
			System.out.println("DLL was empty so, this is 1st node");
			list.head = newnode;
		}
		if (key == 0) {
			currnode = list.head;
			newnode.next = currnode;
			list.head = newnode;
		} else {
			System.out.println("new list : ");
			int count = 1;
			currnode = list.head;
			while ((currnode.next != null) && (key != count)) {
				currnode = currnode.next;
				count = count + 1;
			}
			newnode.next = currnode.next;
			currnode.next.prev = newnode;
			currnode.next = newnode;
			newnode.prev = currnode;

		}
		return list;
	}
// Delet Node by value
	public static Dlink delet(Dlink list) {
		int key = 0;
		Node currnode = null;
		Node temp = null;
		if (list.head == null) {
			System.out.println("DLL is Empty !!!");
		} else {
			System.out.print("Enter Node Value to be Deleted : ");
			Scanner scan = new Scanner(System.in);
			key = scan.nextInt();

			if (key == list.head.data && list.head.next == null) {
				System.out.println("\nThis is only Node in DLL & it is head Node \nso list DLL will be deleted");
				list.head = null;
			} else if (list.head.next != null && key == list.head.data) {
				System.out.println("\nHead Node will change");
				temp = list.head;
				list.head = temp.next;
				temp.next = null;
				temp = null;
			} else {
				currnode = list.head;
				while (currnode.next != null && currnode.next.data != key) {
					currnode = currnode.next;
				}
				temp = currnode.next;
				if (temp.next == null) {
					currnode.next = null;
					temp.prev = null;
				} else {
					currnode.next = temp.next;
					temp.next.prev = currnode;
					temp.next = null;
					temp.prev = null;
				}
			}
		}
		return list;
	}

//  Reverse list
	public static Dlink reverse(Dlink list) {
		Node currnode;
		if (list.head == null) {
			System.out.println("List Is Empty !!");
		} else {
			currnode = list.head;
			while (currnode.next != null) {
				currnode = currnode.next;
			}
			System.out.print("Reverse of list  : ");
			while (currnode != null) {
				System.out.print(" " + currnode.data);
				currnode = currnode.prev;
			}
			System.out.println("\n");
		}

		return list;
	}

	public static void main(String[] args) {
		int choice = 0;
		Dlink list = new Dlink();
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("1.Create DLL");
			System.out.println("2.Display DLL");
			System.out.println("3.Insert at End of DLL");
			System.out.println("4.Insert at Start of DLL");
			System.out.println("5.Insert After given position");
			System.out.println("6.Delet the Node of DLL");
			System.out.println("7.Reverse List");
			System.out.print("\nEnter your choice : ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				int ch = 0;
				do {
					Scanner sc1 = new Scanner(System.in);
					System.out.print("Enter element of linked list : ");
					list = CreateDLL(list, sc1.nextInt());
					System.out.print("Next element 1=yes / 0=no : ");
					ch = sc1.nextInt();
				} while (ch == 1);
				System.out.println("\n");
				break;

			case 2:
				display(list);
				break;

			case 3:
				System.out.println("\nInsert node at END of doubly linked list");
				System.out.print("Enter data to insert : ");
				Scanner input = new Scanner(System.in);
				int data2 = input.nextInt();
				insertAtEnd(data2, list);
				display(list);
				break;

			case 4:
				System.out.println("\nInsert node at START of doubly linked list");
				System.out.print("Enter data to insert : ");
				Scanner input1 = new Scanner(System.in);
				int data3 = input1.nextInt();
				insertatstart(data3, list);
				display(list);
				break;
			case 5:
				System.out.println("\nInsert Node At given POSITION");
				System.out.println("Enter position to insert :");
				int position = sc.nextInt();
				System.out.println("Enter data to insert :");
				int data5 = sc.nextInt();
				insertAtPPosition(position, data5, list);
				display(list);
				break;

			case 6:
				delet(list);
				display(list);
				break;

			case 7:
				reverse(list);
				break;

			default:
				System.out.println("         INVALID CHOICE ");
				break;
			}
		} while (choice < 10);
	}
}