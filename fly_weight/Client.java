package fly_weight;

import java.util.Random;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		Random random=new Random();
		PiecesFactory pf=new PiecesFactory();
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) {
				APiece p;
				if(random.nextInt()%2==0)
					p=pf.GetPiece("����");
				else
					p=pf.GetPiece("����");
				p.Play(random.nextInt(n), random.nextInt(n));
			}
		System.out.println("��ǰ���̹���"+pf.getPiecesCount()+"������");
	}

}
