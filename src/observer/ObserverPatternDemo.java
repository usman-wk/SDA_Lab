package observer;

import observerDemo.src.observer.BinaryObserver;
import observerDemo.src.observer.HexaObserver;
import observerDemo.src.observer.OctalObserver;
import observerDemo.src.observer.Subject;


public class ObserverPatternDemo {
   public static void main(String[] args) {
  
      Subject subject = new Subject();


      BinaryObserver binaryObserver = new BinaryObserver(subject);
      OctalObserver octalObserver = new OctalObserver(subject);
      HexaObserver hexaObserver = new HexaObserver(subject);

  
      subject.attach(binaryObserver);
      subject.attach(octalObserver);
      subject.attach(hexaObserver);


      System.out.println("First state change: 15");
      subject.setState(15); 


      System.out.println("Detaching HexaObserver");
      subject.detach(hexaObserver);


      System.out.println("Second state change: 10");
      subject.setState(10); 

     
   }}