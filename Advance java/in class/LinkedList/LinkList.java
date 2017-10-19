public class LLTest{
   private Node head = null;
   
   class Node{
      private String name;
      private Node next;
   }
   
   public Node(String value){
      name = value;
   }
   
   public void showList(){
      Node current = head;
      
      while(current != null){
         system.out.println(current.name);
         current = current.next;
      }   
   }
   
   public void addAtFront(String st){
      Node tmp = new Node;
      tmp.next = head;
      head = tmp;
   }
   
   public static void main(String[] args){
      LLTest ll = new LLTest();
      ll.addAtFront("hello");
      ll.addAtFront("world");
      ll.addAtFront("how");
      ll.addAtFront("are");
      ll.addAtFront("you");
      ll.showList();

   }

}
