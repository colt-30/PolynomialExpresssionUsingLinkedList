/*   Created by IntelliJ IDEA.
 *   Author: Rajesh kumar (B.tech)
 *   Date: 26-03-2021
 *   Time: 02:31
 *   File: :polynomialExpressionUsingLinkedList.java
 */

package polynomialExpression;

public class Node {
    private int Coefficient;
    private int power;
    private Node next;

    public Node(int coefficient, int power) {
        this.Coefficient = coefficient;
        this.power = power;
    }
    static class LinkedList{
        Node head = null;
        Node tail = null;
        Node addLast(int coefficient, int power){
            Node n = new Node(coefficient, power);
            if(head==null){
                head = n;
                tail= n;
                return head;
            }
            tail.next = n;
            tail=n;
            return head;
        }
        void print(){
            Node temp = head;
            while(temp!=null){
                System.out.println("Coefficient-->"+temp.Coefficient+" "+"power-->"+temp.power);
                temp=temp.next;
            }
        }
        void add(Node head1, Node head2){
            Node temp1 = head1;
            Node temp2 = head2;
            while(temp1!=null || temp2!=null){
                if(temp1.power==temp2.power){
                    addLast(temp1.Coefficient+temp2.Coefficient,temp1.power);
                    temp1=temp1.next;
                    temp2=temp2.next;
                }
                else if(temp1.power>temp2.power){
                    addLast(temp1.Coefficient, temp1.power);
                    temp1=temp1.next;
                }
                else{
                    addLast(temp2.Coefficient, temp2.power);
                    temp2=temp2.next;
                }
            }
        }
        void multiply(Node head1, Node head2){
            Node temp1=head1;
            while(temp1!=null){
                Node temp2 = head2;

                while(temp2!=null){
                    addLast(temp1.Coefficient* temp2.Coefficient, temp1.power
                            + temp2.power);
                    temp2=temp1.next;
                }
                temp1=temp1.next;
            }
        }
        public static void main(String[] args){
            LinkedList l1 = new LinkedList();
            l1.addLast(5,2);
            l1.addLast(3,1);
            l1.addLast(4,0);
            System.out.println("First equation -->");
            l1.print();
            LinkedList l2 = new LinkedList();
            l2.addLast(7,3);
            l2.addLast(5,2);
            l2.addLast(3,0);
            System.out.println("Second equation -->");
            l2.print();
            LinkedList l3 = new LinkedList();
            l3.add(l1.head, l2.head);
            System.out.println("Addition resultant equation -->");
            l3.print();
            LinkedList l4 = new LinkedList();
            l4.multiply(l1.head, l2.head);
            System.out.println("Multiply resultant");
            l4.print();
        }
    }
}