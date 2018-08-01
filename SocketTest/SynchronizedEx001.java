package SocketTest;

public class SynchronizedEx001 {
	public static void main(String []args) {
		ShareObj obj = new ShareObj();
		addThread th1 = new addThread("geonil", obj);
		addThread th2 = new addThread("shina", obj);
		th1.start();
		th2.start();
	}
}




class ShareObj{
	int sum = 0;
	synchronized public void add() {
		int n = sum;
		n += 1;
		sum = n;
		System.out.println(Thread.currentThread().getName()+"-"+sum);
	}
	
	public int getSum() {
		return sum;
	}
	
}

class addThread extends Thread{
	
	ShareObj shObj;
	
	public addThread(String name , ShareObj shObj) {
		super(name);
		this.shObj = shObj;
	}
	
	public void run() {
		int i = 0 ;
		while(i<10) {
			shObj.add();
			i++;
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}











